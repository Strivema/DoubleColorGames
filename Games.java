
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

		System.out.println("*******��ӭ����˫ɫ���Ʊϵͳ*********");
		System.out.println("     *1.�����Ʊ");
		System.out.println("     *2.�鿴����");
		System.out.println("     *3.�˳�");
		System.out.println("-------------------------------");
		System.out.println("����ѡ��˵�");
		do {

			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();

			switch (choice) {
			case 1:
				System.out.println("*1.���ڽ��빺���Ʊ����");

				System.out.println("����Ҫ�����ע");
				count = in.nextInt();
				total = count * PRICE;

				System.out.println("����������Ҫѡ��ĺ���");
				System.out.println("��ѡ��ĺ�ɫ����Ϊ��");
				for (int i = 0; i < len - 1; i++) {
					nums[i] = in.nextInt();
				}
				System.out.println("��ѡ�����ɫ����Ϊ��");
				nums[len - 1] = in.nextInt();
				System.out.println("��������" + count + "ע,��֧��" + total + "Ԫ");
				System.out.println("������ĺ�����");
				for (int i = 0; i < len; i++) {
					System.out.print(nums[i] + " ");
				}

				isBuy = true;
				break;
			case 2:
				
				if (isBuy) {
					System.out.println("*2�鿴�Ƿ��н�");
									
					isBuy = false;
					int[] luckNums = getLuckNums();
					
					System.out.println("������ĺ�����");
					for (int i = 0; i < len; i++) {
						System.out.print(nums[i] + " ");
					}
					System.out.println();
					System.out.println("�н����ǣ�");
					for (int n : luckNums) {
						System.out.print(n + " ");
					}

					System.out.println();
					int result = getCompare(nums, luckNums);
					if (result == 1) {
						System.out.println("��ϲ������һ�Ƚ�,��ý���"+(500*count)+"��Ԫ");
					} else if (result == 2) {
						System.out.println("��ϲ�����˶��Ƚ�,��ý���"+(250*count)+"��Ԫ");
					} else if (result == 3) {
						System.out.println("��ϲ���������Ƚ�,��ý���"+(3000*count)+"Ԫ");
					} else if (result == 4) {
						System.out.println("��ϲ�������ĵȽ�,��ý���"+(200*count)+"Ԫ");
					} else if (result == 5) {
						System.out.println("��ϲ��������Ƚ�,��ý���"+(10*count)+"Ԫ");
					} else if (result == 6) {
						System.out.println("��ϲ���������Ƚ�,��ý���"+(5*count)+"Ԫ");
					} else {
						System.out.println("���ź������û���н�");
					}
				}else{
					System.out.println("����û�й���,��ǰȥ����");
				}
					
				break;
			case 3:
				System.out.println("ллʹ��");
				return;

			default:
				System.out.println("�Բ���û�����ѡ�����������");
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
		 * �ȶ���������ֻ��Ҫһ��ѭ���Ϳ���ʵ��Ч�ʽϸߣ����ǻ�Ҫ���������Ч��
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
		}/** ֱ�Ӷ�����ƥ�䣬Ч�ʲ���
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
