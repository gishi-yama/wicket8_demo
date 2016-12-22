package com.example.page8ex;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;

public class SandBoxPage extends WebPage {

	private static final long serialVersionUID = -1200056271717990556L;

	public SandBoxPage() {
		IModel<String> arom = new IModel<String>() {
			private static final long serialVersionUID = 3165618588539563336L;

			@Override
			public String getObject() {
				return "AbstractReadOnlyModelの代わり";
			}
		};
	}

}
