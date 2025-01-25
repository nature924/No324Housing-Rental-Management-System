package com.currency;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * 生成word合同文档，并转换为pdf类型
 * 
 * @author Administrator
 *
 */
public class DocumentConversion {

	/**
	 * 文档生成
	 */
	public boolean DocumentGeneration(String[] array) {
		ComThread.InitSTA();
		File file = null;
		try {
			file = ResourceUtils.getFile("classpath:房屋合同模板.doc");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		ActiveXComponent app = new ActiveXComponent("Word.Application"); // 启动word
		String inFile = file.getAbsolutePath(); // 要替换的word文件
		// 要保存的目标文件
		String tpFile = "C://cnqf/contract/word/" + (array[0]+array[7]) + "word.doc";
		Dispatch docs = null;
		Dispatch doc = null;
		try {
			app.setProperty("Visible", new Variant(false)); // 设置word不可见
			docs = app.getProperty("Documents").toDispatch();
			doc = Dispatch.invoke(docs, "Open", Dispatch.Method,
					new Object[] { inFile, new Variant(false), new Variant(false) }, new int[1]).toDispatch(); // 打开word文件，注意这里第三个参数要设为false，这个参数表示是否以只读方式打开，因为我们要保存原文件，所以以可写方式打开。
			Dispatch selection = app.getProperty("Selection").toDispatch();// 获得对Selection组件
			Dispatch.call(selection, "HomeKey", new Variant(6));// 移到开头
			Dispatch find = Dispatch.call(selection, "Find").toDispatch();// 获得Find组件
			// 替换
			Dispatch.put(find, "Text", "admin"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", "管理员"); // 替换

			Dispatch.put(find, "Text", "user"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", array[0]); // 替换

			Dispatch.put(find, "Text", "userid"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", array[1]); // 替换

			Dispatch.put(find, "Text", "houseadd"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", array[2]); // 替换

			String[] temp = array[3].split("-");
			Dispatch.put(find, "Text", "year1"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", temp[0]); // 替换

			Dispatch.put(find, "Text", "month1"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", temp[1]); // 替换

			Dispatch.put(find, "Text", "day1"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", temp[2]); // 替换

			String[] temp2 = array[4].split("-");
			Dispatch.put(find, "Text", "year2"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", temp2[0]); // 替换

			Dispatch.put(find, "Text", "month2"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", temp2[1]); // 替换

			Dispatch.put(find, "Text", "day2"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", temp2[2]); // 替换

			Dispatch.put(find, "Text", "monthlyRent"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", String.format("%.2f", Double.parseDouble(array[5]))); // 替换

			double tempmonth = Double.parseDouble(array[5]);
			double tempmonthsum = tempmonth;
			tempmonth *= 0.2;
			Dispatch.put(find, "Text", "deposit"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", String.format("%.2f", tempmonth)); // 替换

			tempmonthsum += tempmonth;
			Dispatch.put(find, "Text", "sumPrice"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", String.format("%.2f", tempmonthsum)); // 替换

			Dispatch.put(find, "Text", "admin2"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", "管理员"); // 替换

			Dispatch.put(find, "Text", "user2"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", array[0]); // 替换

			Dispatch.put(find, "Text", "adminphone"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", "13667446303"); // 替换

			Dispatch.put(find, "Text", "userphone"); // 查找字符串
			Dispatch.call(find, "Execute"); // 执行查询
			Dispatch.put(selection, "Text", array[6]); // 替换
			// 保存文件
			Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] { tpFile, new Variant(0) }, new int[1]); // new
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (app != null) {
				app.invoke("Quit", new Variant[] {});
				app.safeRelease();
				docs.safeRelease();
				doc.safeRelease();
			}
			ComThread.Release();
		}
		return true;
	}

	/**
	 * pdf生成
	 */
	public void PdfGeneration(String userid) {
		ActiveXComponent app = null;

		String wordFile = "C://cnqf/contract/word/"+ userid +"word.doc";
		String pdfFile = "C://cnqf/contract/pdf/" + userid + "pdf.pdf";
		System.out.println("开始转换");
		// 开始时间
		long start = System.currentTimeMillis();
		try {
			// 打开word
			app = new ActiveXComponent("Word.Application");
			// 设置word不可见,很多博客下面这里都写了这一句话，其实是没有必要的，因为默认就是不可见的，如果设置可见就是会打开一个word文档，对于转化为pdf明显是没有必要的
			// app.setProperty("Visible", false);
			// 获得word中所有打开的文档
			Dispatch documents = app.getProperty("Documents").toDispatch();
			System.out.println("打开文件: " + wordFile);
			// 打开文档
			Dispatch document = Dispatch.call(documents, "Open", wordFile, false, true).toDispatch();
			// 如果文件存在的话，不会覆盖，会直接报错，所以我们需要判断文件是否存在
			File target = new File(pdfFile);
			if (target.exists()) {
				target.delete();
			}
			System.out.println("另存为: " + pdfFile);
			// 另存为，将文档报错为pdf，其中word保存为pdf的格式宏的值是17
			Dispatch.call(document, "SaveAs", pdfFile, 17);
			// 关闭文档
			Dispatch.call(document, "Close", false);
			// 结束时间
			long end = System.currentTimeMillis();
			System.out.println("转换成功，用时：" + (end - start) + "ms");
		} catch (Exception e) {
			System.out.println("转换失败" + e.getMessage());
		} finally {
			// 关闭office
			app.invoke("Quit", 0);
		}
	}
}
