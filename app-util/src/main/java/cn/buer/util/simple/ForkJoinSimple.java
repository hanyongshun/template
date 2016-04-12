package cn.buer.util.simple;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSimple {
	
	private static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();
	class WriterFileTask extends RecursiveTask<List<File>>{
		/**
		* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
		*/
		
		private static final long serialVersionUID = 1L;
		private int THRESHOLD = 10000;
		private int start;
		private int end;
		public WriterFileTask(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		protected List<File> compute() {
			List<File> result = new ArrayList<>();
			int sum = end - start;
			if(sum <= THRESHOLD){
				File file = createFile(start, end);
				writerFile(start, end, file);
				result.add(file);
			}else{
				int middle = (start + end)/2;
				WriterFileTask rightTask = new WriterFileTask(start, middle);
				WriterFileTask leftTask = new WriterFileTask(middle + 1, end);
				rightTask.fork();
				leftTask.fork();
				result.addAll(rightTask.join());
				result.addAll(leftTask.join());
			}
			return result;
		}
		
	}
	
	private void writerFile(int start,int end,File file){
		for(;start <= end; start++){
			System.out.println(start);
		}
	}
	private File createFile(int start,int end){
		StringBuilder filePath = new StringBuilder();
//		filePath.append(this.getClass().getClassLoader().getResource("").getPath());
		filePath.append("F:/");
		filePath.append("temp/");
		filePath.append("/forkJoinWork/");
		
		File directory = new File(filePath.toString());
		if(!directory .exists()){
			directory .mkdirs();
		}else{
			filePath.append(String.valueOf(start));
			filePath.append(String.valueOf("-"));
			filePath.append(String.valueOf(end));
			filePath.append(String.valueOf("-"));
			filePath.append(String.valueOf(System.nanoTime()));
			filePath.append(".txt");
			File file = new File(filePath.toString());
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return file;
		}
		return null;
	}
	public static void main(String[] args) {
		ForkJoinSimple simple = new ForkJoinSimple();
		WriterFileTask task =  simple.new WriterFileTask(1, 10000 * 10);
		Future<List<File>> result =  FORK_JOIN_POOL.submit(task);
		try {
			result.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
