package com.fjnl.sa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Problem {
	public static Problem problem = null;
	public static String fileName = null;
    public static Random rand = new Random();
     //打开自己生成的文件
	private Problem(String fileName) throws FileNotFoundException,IOException {
	
		Problem.fileName = fileName;
       	readFile(fileName);
 	}
	//读文件
	private void readFile(String fileName) throws IOException {
		// FileReader类从InputStreamReader类继承而来。该类按字符读取流中数据。
		FileReader data = new  FileReader(fileName);
	    //canner scan =new scanner(system.in)
		//scanner 是一个扫描对象 system.in 是控制台输入 这样就可以获得从控制台输入的参数了
		Scanner scanner =new Scanner(data);
		 int itemNumber = scanner.nextInt();//项
		 int element = scanner.nextInt();//元素
	     int capacity = scanner.nextInt();  //读取容量
		 int bestValue = scanner.nextInt();
		//读取项的值，有几项他就有几个价值
		 values = new int[itemNumber];
		 for(int i=0;i<itemNumber;i++) {
			 
			 values[i]= scanner.nextInt();
			
		 }
		 //读取项中元素的重量
		 weights = new int[element];
	    
	    	 for(int j=0;j<element;j++) {
	    		 weights[j]=scanner.nextInt();
	    	 }
	    //读取0和1关系的二维数组
	    relation = new int[itemNumber][element];
	     
	        for(int i=0;i<itemNumber;i++) {
	        	for(int j=0;j<element;j++) {
	        		 relation[i][j] = scanner.nextInt();
	        	}
	        }
	     scanner.close();
	     data.close();
	}
	
	
	    private int itemNumber;//项
	    private int element;//元素
	    private int capacity; //背包的容量
	    private int bestValue; //最优解
		private int[] values; //项的价值为数组
		private int[] weights; //元素的重量
		private int[][]  relation;//0、1关系的输出
		
		
		public static Problem getProblem() {
			return problem;
		}
		public static void setProblem(Problem problem) {
			Problem.problem = problem;
		}
		public static String getFileName() {
			return fileName;
		}
		public static void setFileName(String fileName) {
			Problem.fileName = fileName;
		}
		public static Random getRand() {
			return rand;
		}
		public static void setRand(Random rand) {
			Problem.rand = rand;
		}
		public int getItemNumber() {
			return itemNumber;
		}
		public void setItemNumber(int itemNumber) {
			this.itemNumber = itemNumber;
		}
		public int getElement() {
			return element;
		}
		public void setElement(int element) {
			this.element = element;
		}
		public double getCapacity() {
			return capacity;
		}
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
		public double getBestValue() {
			return bestValue;
		}
		public void setBestValue(int bestValue) {
			this.bestValue = bestValue;
		}
		public int[] getValues() {
			return values;
		}
		public void setValues(int[] values) {
			this.values = values;
		}
		public int[] getWeights() {
			return weights;
		}
		public void setWeights(int[] weights) {
			this.weights = weights;
		}
		public int[][] getRelation() {
			return relation;
		}
		public void setRelation(int[][] relation) {
			this.relation = relation;
		}
		
		
		public Problem(int itemNumber, int element, int capacity, int bestValue, int[] values,
				int[] weights, int[][] relation) {
			super();
			this.itemNumber = itemNumber;
			this.element = element;
			this.capacity = capacity;
			this.bestValue = bestValue;
			this.values = values;
			this.weights = weights;
			this.relation = relation;
		}
		
		public Problem() {
			super();
			// TODO Auto-generated constructor stub
		}
		//toString()将任何对象转换成字符串表达形式
		@Override
		public String toString() {
			//带缓冲的字符串
			StringBuffer out = new StringBuffer();
			//列表后添加元素
			//  \n:换行   \t:空格
			out.append(problem.itemNumber+ "\t" + element + "\t"+capacity+"\t"+bestValue+ "\n");
			for (int i = 0; i < values.length; i++) {
				out.append(values[i]+"\t");
			}
			   out.append("\n");
		
			for (int i = 0; i < weights.length; i++) {
				
				out.append(weights[i]+"\t");
			}
			out.append("\n");
			
			for(int i=0;i<itemNumber;i++) {
				for(int j=0;j<element;j++) {
					out.append(relation[itemNumber][element]+"\t");
				}
			}
			out.append("\n");
			
		
				
			return out.toString();
		}
		
		
		public static void main(String[] args) throws IOException {
			
			
			//路径
			String filePath = (new File("")).getAbsolutePath() + "/SUKPInstancesGreater/";
			//文件名
			fileName = filePath + "01-sukp 100_85_0.10_0.75.txt";
			try {
			
				problem = new Problem(fileName);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			System.out.println(problem);
		}
		
	/*	
		public static void readAndSaveFiles() throws IOException {
			String filePath = (new File("")).getAbsolutePath()+"/SUKPInstancesGreater/";
		    //有多个文件
			File[] files=(new File(filePath)).listFiles();
			//遍历多个txt文件
			for(File file:files) {
				
				String dirName = file.getName().replaceAll(".txt", "");
				String dirPath = (new File("")).getAbsolutePath() + "/../" + dirName + "/";
				File dir = new File(dirPath);
				if(!dir.exists()) {
					//如果目录不存在，自动生成一个新的
					   dir.mkdir();
				}
			
			 * FileReader data; Scanner scan; data = new FileReader(file); scan = new
			 * Scanner(data);
			 
							
			}*/
	/*
	 * }
	 */

}
