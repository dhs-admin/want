package gov.dhs.nettester.gwt.client.gui;

import com.google.gwt.aria.client.Roles;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTML;

/**
 * @author steveq@nist.gov
 */
public class MessageDialogBox extends DialogBox {
	public PushButton closeButton;
	private HTML messageLabel_1;

	public MessageDialogBox(String message, boolean error) {
		super(false, true);
		setWidth("335px");
		setAnimationEnabled(false);
		final VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.setWidget(dialogVPanel);
		dialogVPanel.setSize("307px", "138px");
		messageLabel_1 = new HTML(message);
		dialogVPanel.add(messageLabel_1);
		dialogVPanel.setCellVerticalAlignment(messageLabel_1, HasVerticalAlignment.ALIGN_MIDDLE);
		messageLabel_1.setHeight("25px");
		if (error) {
			messageLabel_1.setStyleName("errorMessageDialog");
		} else {
			messageLabel_1.setStyleName("messageDialog");
		}
		messageLabel_1
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		dialogVPanel.setCellHorizontalAlignment(messageLabel_1,
				HasHorizontalAlignment.ALIGN_CENTER);
		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setStyleName("buttonPanel");
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		dialogVPanel.add(horizontalPanel);
		dialogVPanel.setCellHorizontalAlignment(horizontalPanel,
				HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.setWidth("320px");
		closeButton = new PushButton("Ok");
		Roles.getButtonRole().setAriaLabelProperty(closeButton.getElement(),
				"Close Button");

		closeButton.setTitle("Close");
		closeButton.setStyleName("greenButton shadow");
		horizontalPanel.add(closeButton);
		dialogVPanel.setCellWidth(closeButton, "100%");
		closeButton.setSize("70px", "18px");
		dialogVPanel.setCellVerticalAlignment(closeButton,
				HasVerticalAlignment.ALIGN_MIDDLE);
		dialogVPanel.setCellHorizontalAlignment(closeButton,
				HasHorizontalAlignment.ALIGN_CENTER);
	}

	/** This fixes focus for dialog boxes in Firefox and IE browsers */
	@Override
	public void show() {
		super.show();
		Scheduler.get().scheduleDeferred(new Command() {
			public void execute() {
				closeButton.setFocus(true);
			}
		});
	}
}
