
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
 * 
 * @author Marie
 *
 */
public class Games {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int total = 0;
		final int PRICE = 2;
		int count=0;
		boolean isBuy = false;
		int nums[] = new int[7];
		int len = nums.length;

		System.out.println("*******欢迎进入双色球彩票系统*********");
		System.out.println("     *1.购买彩票");
		System.out.println("     *2.查看开奖");
		System.out.println("     *3.退出");
		System.out.println("-------------------------------");
		System.out.println("请您选择菜单");
		do {

			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();

			switch (choice) {
			case 1:
				System.out.println("*1.现在进入购买彩票功能");

				System.out.println("您需要买多少注");
				count = in.nextInt();
				total = count * PRICE;

				System.out.println("请输入您需要选择的号码");
				System.out.println("您选择的红色号码为：");
				for (int i = 0; i < len - 1; i++) {
					nums[i] = in.nextInt();
				}
				System.out.println("您选择的蓝色号码为：");
				nums[len - 1] = in.nextInt();
				System.out.println("您共买了" + count + "注,共支付" + total + "元");
				System.out.println("您购买的号码是");
				for (int i = 0; i < len; i++) {
					System.out.print(nums[i] + " ");
				}

				isBuy = true;
				break;
			case 2:
				
				if (isBuy) {
					System.out.println("*2查看是否中奖");
									
					isBuy = false;
					int[] luckNums = getLuckNums();
					
					System.out.println("您购买的号码是");
					for (int i = 0; i < len; i++) {
						System.out.print(nums[i] + " ");
					}
					System.out.println();
					System.out.println("中奖号是：");
					for (int n : luckNums) {
						System.out.print(n + " ");
					}

					System.out.println();
					int result = getCompare(nums, luckNums);
					if (result == 1) {
						System.out.println("恭喜你中了一等奖,获得奖金"+(500*count)+"万元");
					} else if (result == 2) {
						System.out.println("恭喜你中了二等奖,获得奖金"+(250*count)+"万元");
					} else if (result == 3) {
						System.out.println("恭喜你中了三等奖,获得奖金"+(3000*count)+"元");
					} else if (result == 4) {
						System.out.println("恭喜你中了四等奖,获得奖金"+(200*count)+"元");
					} else if (result == 5) {
						System.out.println("恭喜你中了五等奖,获得奖金"+(10*count)+"元");
					} else if (result == 6) {
						System.out.println("恭喜你中了六等奖,获得奖金"+(5*count)+"元");
					} else {
						System.out.println("很遗憾您这次没有中奖");
					}
				}else{
					System.out.println("您还没有购买,请前去购买");
				}
					
				break;
			case 3:
				System.out.println("谢谢使用");
				return;

			default:
				System.out.println("对不起没有这个选项，请重新输入");
				break;
			}

		} while (true);
	}

	public static int getCompare(int nums[], int luckNum[]) {

		int len1 = nums.length;
		int len2 = luckNum.length;

		int redNum = 0;
		int blueNum = 0;
		int level = 0;
		/**
		 * 先对数组排序，只需要一层循环就可以实现效率较高，但是还要考虑排序的效率
		 */
		Arrays.sort(nums);
		Arrays.sort(luckNum);
		for(int i=0;i<len1;i++){
			if(i<len1-1){
				if(nums[i]==luckNum[i])
					redNum++;
			}else{
				if(nums[len1-1]==luckNum[len1-1]){
					blueNum++;
				}
			}
		}/** 直接对数组匹配，效率不高
	      */
		/*for (int i = 0; i < len1; i++) {
			if (i < len1 - 1) {
				int red = nums[i];
				for (int j = 0; j < len2; j++) {
					if (red == luckNum[j])
						redNum++;
				}
			} else {
				if (nums[len1 - 1] == luckNum[len2 - 1]) {
					blueNum++;
				}
			}
		}*/
		if (redNum == 6 && blueNum == 1) {
			level = 1;
		} else if (redNum == 6) {
			level = 2;
		} else if (redNum == 5 && blueNum == 1) {
			level = 3;
		} else if (redNum == 5 || (redNum == 4 && blueNum == 1)) {
			level = 4;
		} else if (redNum == 4 || (redNum == 3 && blueNum == 1)) {
			level = 5;
		} else if (blueNum == 1) {
			level = 6;
		}

		return level;
	}

	public static int[] getLuckNums() {
		int luckNums[] = {1,2,3,4,5,6,7};
		return luckNums;
		/*int luckNums[] = new int[7];
		int leng = luckNums.length;
		for (int i = 0; i < leng; i++) {
			if (i < leng - 1) {
				luckNums[i] = (int) (Math.random() * 33 + 1);
			} else
				luckNums[i] = (int) (Math.random() * 16 + 1);
		}
		return luckNums;*/
	}
}
