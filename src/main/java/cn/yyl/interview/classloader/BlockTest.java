package cn.yyl.interview.classloader;
import java.util.*;
import java.util.stream.Collectors;

public class BlockTest {

	public static class Block {
		private List<Double> recBoxes; // [left, top, right, bottom]
		private String recText;
		private int textLength;

		public Block(List<Double> recBoxes, String recText, int textLength) {
			this.recBoxes = recBoxes;
			this.recText = recText;
			this.textLength = textLength;
		}

		public double getLeft() { return recBoxes.get(0); }
		public double getTop() { return recBoxes.get(1); }
		public double getRight() { return recBoxes.get(2); }
		public double getBottom() { return recBoxes.get(3); }
		public String getText() { return recText; }
		public int getTextLength() { return textLength; }

		@Override
		public String toString() {
			return String.format("Block{text='%s', top=%.1f, left=%.1f}",
					recText, getTop(), getLeft());
		}
	}

	/**
	 * 主要处理方法：排序和分块
	 */
	public static List<List<Block>> processOCRBlocks(List<Block> blocks) {
		if (blocks == null || blocks.isEmpty()) {
			return new ArrayList<>();
		}

		// 过滤空文本的block
		List<Block> filteredBlocks = blocks.stream()
				.filter(block -> block.getTextLength() > 0 && !block.getText().trim().isEmpty())
				.collect(Collectors.toList());

		// 第一步：从上到下、从左到右排序
		List<Block> sortedBlocks = filteredBlocks.stream()
				.sorted(Comparator
						.comparingDouble(Block::getTop)
						.thenComparingDouble(Block::getLeft))
				.collect(Collectors.toList());

		// 第二步：按聚集度分块
		return groupBlocksByProximity(sortedBlocks);
	}

	/**
	 * 基于位置接近度分块
	 */
	private static List<List<Block>> groupBlocksByProximity(List<Block> sortedBlocks) {
		List<List<Block>> groups = new ArrayList<>();
		if (sortedBlocks.isEmpty()) return groups;

		// 计算平均行高用于阈值
		double avgLineHeight = sortedBlocks.stream()
				.mapToDouble(block -> block.getBottom() - block.getTop())
				.average()
				.orElse(20.0); // 默认20

		double lineThreshold = avgLineHeight * 1.5; // 行间距阈值
		double columnThreshold = 200.0; // 列间距阈值

		List<Block> currentGroup = new ArrayList<>();
		currentGroup.add(sortedBlocks.get(0));

		for (int i = 1; i < sortedBlocks.size(); i++) {
			Block current = sortedBlocks.get(i);
			Block prev = sortedBlocks.get(i - 1);

			double verticalGap = current.getTop() - prev.getBottom();
			double horizontalGap = Math.abs(current.getLeft() - prev.getLeft());

			// 判断是否同一组的条件
			boolean sameGroup = false;

			// 条件1：垂直距离小，认为是同一段落
			if (verticalGap <= lineThreshold) {
				sameGroup = true;
			}
			// 条件2：水平位置接近，可能是同一行的不同部分
			else if (verticalGap <= lineThreshold * 2 && horizontalGap <= columnThreshold) {
				sameGroup = true;
			}
			// 条件3：明显的图表数据（数字、百分比等）
			else if (isChartData(prev) && isChartData(current) && verticalGap <= avgLineHeight * 3) {
				sameGroup = true;
			}

			if (sameGroup) {
				currentGroup.add(current);
			} else {
				// 对当前组按阅读顺序排序（主要按垂直，次要按水平）
				currentGroup.sort(Comparator
						.comparingDouble(Block::getTop)
						.thenComparingDouble(Block::getLeft));
				groups.add(new ArrayList<>(currentGroup));
				currentGroup = new ArrayList<>();
				currentGroup.add(current);
			}
		}

		// 添加最后一组
		if (!currentGroup.isEmpty()) {
			currentGroup.sort(Comparator
					.comparingDouble(Block::getTop)
					.thenComparingDouble(Block::getLeft));
			groups.add(currentGroup);
		}

		return groups;
	}

	/**
	 * 判断是否为图表数据（数字、百分比等）
	 */
	private static boolean isChartData(Block block) {
		String text = block.getText().trim();
		// 匹配百分比、数字、P值等
		return text.matches("[0-9%.].*") ||
		text.startsWith("P") ||
				text.contains("%") ||
				text.matches("\\d+(\\.\\d+)?.*");
	}

	/**
	 * 合并分组内的文本
	 */
	public static String mergeGroupText(List<Block> group) {
		return group.stream()
				.map(Block::getText)
				.collect(Collectors.joining(" "));
	}

	/**
	 * 打印分组结果
	 */
	public static void printResults(List<List<Block>> groups) {
		System.out.println("=== OCR Blocks分组结果 ===");
		System.out.println("共 " + groups.size() + " 个分组\n");

		for (int i = 0; i < groups.size(); i++) {
			System.out.println("分组 " + (i + 1) + ":");
			List<Block> group = groups.get(i);

			// 打印每个block的详细信息
			for (Block block : group) {
				System.out.println("  " + block);
			}

			// 打印合并后的文本
			String mergedText = mergeGroupText(group);
			System.out.println("  合并文本: " + mergedText);
			System.out.println();
		}
	}

	/**
	 * 创建测试数据（基于你提供的JSON）
	 */
	public static List<Block> createTestData() {
		List<Block> blocks = new ArrayList<>();

		// 添加你的数据（这里只添加部分作为示例）
		blocks.add(new Block(Arrays.asList(72.0, 31.0, 865.0, 60.0),
				"EGFR阳性NSCLC相⽐野⽣型患者可能具有更⾼的远处转移⻛险", 31));
		blocks.add(new Block(Arrays.asList(60.0, 89.0, 716.0, 112.0),
				"• EGFR突变型与野⽣型NSCLC似乎具有相似的疾病复发率，5年复发率约为40%，", 42));
		blocks.add(new Block(Arrays.asList(77.0, 122.0, 678.0, 143.0),
				"但在复发⼈群中，EGFR阳性患者相⽐野⽣型患者具有更⾼的远处转移⻛险。", 35));
		blocks.add(new Block(Arrays.asList(136.0, 171.0, 410.0, 193.0),
				"复发患者的远处转移⻛险显著升⾼", 15));
		blocks.add(new Block(Arrays.asList(633.0, 171.0, 800.0, 193.0),
				"脑转移⻛险显著升⾼", 9));
		blocks.add(new Block(Arrays.asList(701.0, 214.0, 767.0, 237.0),
				"P<0.01", 6));
		blocks.add(new Block(Arrays.asList(266.0, 217.0, 336.0, 234.0),
				"P=0.007", 7));
		blocks.add(new Block(Arrays.asList(201.0, 247.0, 241.0, 266.0),
				"97%", 3));
		blocks.add(new Block(Arrays.asList(517.0, 241.0, 581.0, 260.0),
				"20.0%", 5));
		blocks.add(new Block(Arrays.asList(86.0, 258.0, 139.0, 277.0),
				"100%", 4));

		// 添加更多数据...
		blocks.add(new Block(Arrays.asList(73.0, 453.0, 451.0, 463.0),
				"⼀项单中⼼回顾性研究纳⼊282例早期或局部晚期肺腺癌患者，评估患者", 33));
		blocks.add(new Block(Arrays.asList(514.0, 453.0, 895.0, 463.0),
				"⽇本⼀项研究对⽇本癌症联合委员会注册数据库（⼀个⼿术切除癌症患者", 32));

		return blocks;
	}

	public static void main(String[] args) {
		// 创建测试数据
		List<Block> testBlocks = createTestData();

		// 处理blocks
		List<List<Block>> resultGroups = processOCRBlocks(testBlocks);

		// 打印结果
		printResults(resultGroups);

		// 也可以输出为JSON格式
		System.out.println("=== JSON格式输出 ===");
		System.out.println("[");
		for (int i = 0; i < resultGroups.size(); i++) {
			System.out.println("  {");
			System.out.println("    \"group\": " + (i + 1) + ",");
			System.out.println("    \"text\": \"" + mergeGroupText(resultGroups.get(i)) + "\"");
			System.out.println(i < resultGroups.size() - 1 ? "  }," : "  }");
		}
		System.out.println("]");
	}
}