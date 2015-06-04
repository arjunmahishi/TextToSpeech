package data;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;

public class TextToSpeech {

	protected Shell frm;
	private Text T1;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TextToSpeech window = new TextToSpeech();
			window.open();
					} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		frm.open();
		frm.layout();
		while (!frm.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		frm = new Shell();
		frm.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		frm.setSize(450, 300);
		frm.setText("Text-To-Speech");

		final Button in = new Button(frm, SWT.RADIO);
		in.setFont(SWTResourceManager.getFont("Terminal", 9, SWT.BOLD));
		in.setBounds(70, 138, 90, 16);
		in.setText("Indian");
		in.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));

		final Button am = new Button(frm, SWT.RADIO);
		am.setFont(SWTResourceManager.getFont("Terminal", 9, SWT.BOLD));
		am.setSelection(true);
		am.setBounds(70, 116, 90, 16);
		am.setText("American");
		am.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));

		final Button br = new Button(frm, SWT.RADIO);
		br.setFont(SWTResourceManager.getFont("Terminal", 9, SWT.BOLD));
		br.setBounds(70, 160, 90, 16);
		br.setText("British");
		br.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		
		T1 = new Text(frm, SWT.BORDER);
		T1.setToolTipText("Say something...");
		T1.setBounds(104, 42, 320, 21);
		 
		Button btnNewButton = new Button(frm, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager
				.getFont("Terminal", 9, SWT.BOLD));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			  if (in.getSelection()) {
					SpeechClass.say(T1.getText(), "hi");
				} else if (br.getSelection()) {
					SpeechClass.say(T1.getText(), "en-uk");
				} else if (am.getSelection()) {
					SpeechClass.say(T1.getText(), "en-us");
				}  
				
			}
		});


		
	
		btnNewButton.setBounds(298, 89, 90, 25);
		btnNewButton.setText("&Speak");

		Label lblNewLabel = new Label(frm, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI Symbol", 7,
				SWT.BOLD));
		lblNewLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BORDER));
		lblNewLabel.setBounds(348, 247, 86, 15);
		lblNewLabel.setText("\u00A9 Arjun Mahishi");

		Label lblEnterText = new Label(frm, SWT.NONE);
		lblEnterText.setFont(SWTResourceManager
				.getFont("Terminal", 9, SWT.BOLD));
		lblEnterText
				.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblEnterText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BORDER));
		lblEnterText.setBounds(10, 47, 90, 15);
		lblEnterText.setText("Enter text :");

		Label lblAccent = new Label(frm, SWT.NONE);
		lblAccent.setFont(SWTResourceManager.getFont("Terminal", 9, SWT.BOLD));
		lblAccent.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblAccent.setBounds(62, 95, 81, 15);
		lblAccent.setText("Accent :");
		lblAccent.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BORDER));

		Menu menu = new Menu(frm);
		frm.setMenu(menu);

	}
}
