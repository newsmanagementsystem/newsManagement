package com.seven.entity;

import java.util.Date;

/*
 * 新闻实体类
 * 
 * newsId：新闻ID
 * themeId：主题ID
 * newsTitle：新闻标题
 * newsAuthor：新闻作者
 * newsCreatedate：新闻创作时间
 * newsModifydate：新闻修改时间
 * newsSummary：新闻摘要
 * newsContent：新闻内容
 * newsPicpath：新闻图片地址
 * 
 */
public class News {
	private int newsId;
	private int themeId;
	private String newsTitle;
	private String newsAuthor;
	private Date newsCreatedate;
	private Date newsModifydate;
	private String newsPicpath;
	private String newsContent;
	private String newsSummary;
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public int getThemeId() {
		return themeId;
	}
	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsAuthor() {
		return newsAuthor;
	}
	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}
	public Date getNewsCreatedate() {
		return newsCreatedate;
	}
	public void setNewsCreatedate(Date newsCreatedate) {
		this.newsCreatedate = newsCreatedate;
	}
	public Date getNewsModifydate() {
		return newsModifydate;
	}
	public void setNewsModifydate(Date newsModifydate) {
		this.newsModifydate = newsModifydate;
	}
	public String getNewsPicpath() {
		return newsPicpath;
	}
	public void setNewsPicpath(String newsPicpath) {
		this.newsPicpath = newsPicpath;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getNewsSummary() {
		return newsSummary;
	}
	public void setNewsSummary(String newsSummary) {
		this.newsSummary = newsSummary;
	}
	
}
