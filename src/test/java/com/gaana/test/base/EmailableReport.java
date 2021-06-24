package com.gaana.test.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailableReport {
	
	public static PrintWriter out;
	public static int row;
	Date sd,ed;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public PrintWriter createWriter(String outdir) throws IOException {

		new File(outdir).mkdirs();
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, "report.html"))));

	}
	
	public void startHtml(PrintWriter out) {
		out.println(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<title>TestNG Report</title>");
		out.println("<style type=\"text/css\">");
		out.println("table {margin-bottom:10px;border-collapse:collapse;empty-cells:show}");
		out.println("td,th {border:1px solid #009;padding:.25em .5em}");
		out.println(".result th {vertical-align:bottom}");
		out.println(".param th {padding-left:1em;padding-right:1em}");
		out.println(".param td {padding-left:.5em;padding-right:2em}");
		out.println(".stripe td,.stripe th {background-color: #E6EBF9}");
		out.println(".numi,.numi_attn {text-align:right}");
		out.println(".total td {font-weight:bold}");
		out.println(".passedodd td {background-color: #0A0}");
		out.println(".passedeven td {background-color: #3F3}");
		out.println(".skippedodd td,.numi1_attn {background-color: #ebeb00}");
		out.println(".skippedodd td,.stripe .numi1_attn {background-color: #ebeb00}");
		out.println(".failedodd td,.numi_attn {background-color: #F33}");
		out.println(".failedeven td,.stripe .numi_attn {background-color: #D00}");
		out.println(".stacktrace {white-space:pre;font-family:monospace}");
		out.println(".totop {font-size:85%;text-align:center;border-bottom:2px solid #000}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
	}
	
	public void tableStart(String cssclass, String id) {
		out.println("<table cellspacing=\"0\" cellpadding=\"0\""
				+ (cssclass != null ? " class=\"" + cssclass + "\"" : " style=\"padding-bottom:2em\"")
				+ (id != null ? " id=\"" + id + "\"" : "") + ">");
		
	}

	public void summaryCell(String v, boolean isgood) {
		out.print("<td class=\"numi" + (isgood ? "" : "_attn") + "\">" + v + "</td>");
	}
	
	public void startResultSummaryTable(String style) {
		tableStart(style, "summary");
		out.println("<tr style=\"\r\n" + "    background-color: #0066cc;\r\n" + "    color: white;\r\n"
				+ "\"><th>Total Tests</th>" + "<th>Passed</th>" + "<th>Failed</th>" + "<th>Start Time</th>" + "<th>End Time</th>" + "<th>Total Time</th></tr>");
	}
	
	public void updateResultSummaryTable() {
		out.print("<tr>");
		summaryCell(String.valueOf(Test_Runner.totalScenarioCount), true);
		summaryCell(String.valueOf(Test_Runner.passedScenarioCount), true);
		summaryCell(String.valueOf(Test_Runner.failedScenarioCount), true);
		summaryCell(Test_Runner.startDate, true);
		summaryCell(Test_Runner.endDate, true);
		summaryCell(Test_Runner.totalTime, true);
		out.print("</tr></table>");
	}
	
	public void startScenarioSummaryTable(String style) {
		tableStart(style, "summary");
		out.println("<tr style=\"\r\n" + "    background-color: #0066cc;\r\n" + "    color: white;\r\n"
				+ "\"><th>S.No</th>" + "<th>Test Case</th>" + "<th>Status</th></tr>");
		
	}
	
	public void endHtml(PrintWriter out) {
		out.println("</table></body></html>");
	}
	
	public String millisToTimeConversion(long seconds) {

		final int MINUTES_IN_AN_HOUR = 60;
		final int SECONDS_IN_A_MINUTE = 60;

		int minutes = (int) (seconds / SECONDS_IN_A_MINUTE);
		seconds -= minutes * SECONDS_IN_A_MINUTE;

		int hours = minutes / MINUTES_IN_AN_HOUR;
		minutes -= hours * MINUTES_IN_AN_HOUR;

		return prefixZeroToDigit(hours) + ":" + prefixZeroToDigit(minutes) + ":" + prefixZeroToDigit((int) seconds);
	}
	
	public String prefixZeroToDigit(int num) {
		int number = num;
		if (number <= 9) {
			String sNumber = "0" + number;
			return sNumber;
		} else
			return "" + number;

	}
	
	public String startTime() {
		sd = new Date();
		return formatter.format(sd);
	}
	
	public String endTime() {
		ed = new Date();
		return formatter.format(ed);
	}
	
	public String totalTime() {
		return millisToTimeConversion((ed.getTime() - sd.getTime())/1000);
	}



}
