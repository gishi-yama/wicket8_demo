package com.example.page8;

import com.example.page8.form.OrderPage01;
import com.example.page8.form.OrderPage02;
import com.example.page8.listview.ListPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class IndexPage extends WebPage {

	public IndexPage() {
		add(Link.onClick("toListPage", (link) -> setResponsePage(new ListPage())));
		add(Link.onClick("toOrderPage1", (link) -> setResponsePage(new OrderPage01())));
		add(Link.onClick("toOrderPage2", (link) -> setResponsePage(new OrderPage02())));
	}
}
