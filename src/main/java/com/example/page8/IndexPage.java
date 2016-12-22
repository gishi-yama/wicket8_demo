package com.example.page8;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class IndexPage extends WebPage {

	public IndexPage() {
		add(new BookmarkablePageLink<>("toListPage", ListPage.class));
		add(new BookmarkablePageLink<>("toOrderPage1", OrderPage01.class));
	}
}
