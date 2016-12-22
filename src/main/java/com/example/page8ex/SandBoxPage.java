package com.example.page8ex;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;

/**
 * Created by jyukai on 2016/12/22.
 */
public class SandBoxPage extends WebPage {

	public SandBoxPage() {
		IModel<String> arom = new IModel<String>(){

			@Override
			public String getObject() {
				return "AbstractReadOnlyModelの代わり";
			}
		};


	}

}
