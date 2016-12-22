package com.example.page;

import com.example.page.ajax.AjaxOrderPage;
import com.example.page.ajax.TimerPage;
import com.example.page.form.OrderPage01;
import com.example.page.form.OrderPage02;
import com.example.page.listview.ListPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class IndexPage extends WebPage {
	private static final long serialVersionUID = 1010314105054227997L;

	public IndexPage() {
		add(Link.onClick("toListPage", (link) -> setResponsePage(new ListPage())));
		add(Link.onClick("toOrderPage01", (link) -> setResponsePage(new OrderPage01())));
		add(Link.onClick("toOrderPage02", (link) -> setResponsePage(new OrderPage02())));
		add(Link.onClick("toAjaxOrderPage", (link) -> setResponsePage(new AjaxOrderPage())));
		add(Link.onClick("toTimerPage", (link) -> setResponsePage(new TimerPage())));
	}
}
