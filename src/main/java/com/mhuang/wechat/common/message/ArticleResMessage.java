package com.mhuang.wechat.common.message;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.mhuang.wechat.common.message.child.Article;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * 
 * @Description 图文响应消息
 * @author mHuang
 * @date 2015年6月4日 下午4:54:10 
 * @version V1.0.0
 */
public class ArticleResMessage extends BaseMessage{

	private static final long serialVersionUID = 1L;

	private static final String NEWS = "news";
	
	private Integer articleCount = 0;
	
	@JSONField(serialize=false)
	private List<Article> articles = new ArrayList<Article>();

	@JSONField(name=NEWS)
	@XStreamOmitField
	private ArticleList  articleList = new ArticleList();
	
	public ArticleResMessage(){
		setMsgType(NEWS);
	}
	
	public ArticleResMessage(String toUserName,String fromUserName){
		super(toUserName,fromUserName);
		setMsgType(NEWS);
	}
	
	public Integer getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public void addArticle(Article article){
		articles.add(article);
		articleCount = articles.size();
	}
	
	public void addArticle(String title,String descption,String picUrl,String url){
		addArticle(Article.getArticle(title, descption, picUrl, url));
	}
	
	public ArticleList getArticleList() {
		return articleList;
	}

	public void setArticleList(ArticleList articleList) {
		this.articleList = articleList;
	}
	
	public void addJSONArticle(Article article){
		articleList.articles.add(article);
		articleCount = articleList.articles.size();
	}
	
	public void addJSONArticle(String title,String descption,String picUrl,String url){
		addJSONArticle(Article.getArticle(title, descption, picUrl, url));
	}

	class ArticleList{
		private List<Article> articles = new ArrayList<Article>();

		public List<Article> getArticles() {
			return articles;
		}

		public void setArticles(List<Article> articles) {
			this.articles = articles;
		}
		
	}
}
