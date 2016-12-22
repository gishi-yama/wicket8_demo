package com.example.page.ajax;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.LoadableDetachableModel;

import java.time.LocalDateTime;

import static org.apache.wicket.ajax.AbstractAjaxTimerBehavior.onTimer;
import static org.apache.wicket.util.time.Duration.ONE_SECOND;

public class TimerPage extends WebPage {
	private static final long serialVersionUID = 4410501689099589100L;

	public TimerPage() {
		add(new Label("timer", LoadableDetachableModel.of(LocalDateTime::now))
			.setOutputMarkupId(true)
			.add(onTimer(ONE_SECOND, (t) -> t.add(getPage().get("timer")))));
	}
}
