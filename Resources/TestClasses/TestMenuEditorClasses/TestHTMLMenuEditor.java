package TestClasses.TestMenuEditorClasses;

import TemplateEditor.MenuEditor.HTMLMenuEditor;
import TemplateEditor.PageEditor;
import TemplateHandlerClasses.PageTemplate;
import TemplateHandlerClasses.TemplateFactory;
import TemplateHandlerClasses.Templates;
import TestClasses.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Konrad on 2017-08-04.
 */
public class TestHTMLMenuEditor extends Test {
    TestHTMLMenuEditor() {
        super("TestHTMLMenuEditor");
    }

    private void testFirstTemplate() {
        PageTemplate template = TemplateFactory.getInstance().create(Templates.FIRST);

        ArrayList<String> options = new ArrayList<>();
        Collections.addAll(options, "Opcja1", "Opcja2");

        ArrayList<PageEditor> editors = new ArrayList<>();
        Collections.addAll(editors, HTMLMenuEditor.getOptionEditor(options, Templates.FIRST));

        for (PageEditor editor : editors) {
            editor.edit(template);
        }

        String correct = "<!DOCTYPE html>\n" +
                "\n" +
                "<html>\n" +
                "\t<body>\n" +
                "\t\t<div class=\"Title\">\n" +
                "\t\t\t<p class=\"TitleText\"> Title </p>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"Menu\">\n" +
                "\t\t\t<table class=\"fillParent\">\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t<a href=\"Opcja1.html\" target=\"iframe\">Opcja1</a>\n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t<a href=\"Opcja2.html\" target=\"iframe\">Opcja2</a>\n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</table>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"Content\">\n" +
                "\t\t\t<iframe name=\"iframe\" width=\"100%\" height=\"100%\" frameborder=\"0\">Twoja przegladarka nie obsluguje iFrame!!</iframe>\n" +
                "\t\t</div>\n" +
                "\t\t<br/>\n" +
                "\t\t<div class=\"dolny\"></div>\n" +
                "\t</body>\n" +
                "</html>";

        if (!template.getHTMLDoc().toString().equals(correct)) {
            reportError("Expected: " + correct + " Got:" + template.getHTMLDoc().toString());
        }
    }

    private void testSecondTemplate() {
        PageTemplate template = TemplateFactory.getInstance().create(Templates.SECOND);


        ArrayList<String> options = new ArrayList<>();
        Collections.addAll(options, "Opcja1", "Opcja2");

        ArrayList<PageEditor> editors = new ArrayList<>();
        Collections.addAll(editors, HTMLMenuEditor.getOptionEditor(options, Templates.SECOND));

        for (PageEditor editor : editors) {
            editor.edit(template);
        }

        String correct = "<!DOCTYPE html>\n" +
                "\n" +
                "<html>\n" +
                "\t<body>\n" +
                "\t\t<div class=\"Title\">\n" +
                "\t\t\t<p class=\"TitleText\"> Title </p>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"Menu\">\n" +
                "\t\t\t<table class=\"fillParent\">\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t<a href=\"Opcja1.html\" target=\"iframe\">Opcja1</a>\n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t<a href=\"Opcja2.html\" target=\"iframe\">Opcja2</a>\n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</table>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"Content\">\n" +
                "\t\t\t<iframe name=\"iframe\" width=\"100%\" height=\"100%\" frameborder=\"0\">Twoja przegladarka nie obsluguje iFrame!!!</iframe>\n" +
                "\t\t</div>\n" +
                "\t\t<br/>\n" +
                "\t\t<div class=\"dolny\"></div>\n" +
                "\t</body>\n" +
                "</html>";

        if (!template.getHTMLDoc().toString().equals(correct)) {
            reportError("Expected: " + correct + " Got:" + template.getHTMLDoc().toString());
        }
    }

    public void test() {
        super.test();

        testFirstTemplate();
        testSecondTemplate();

        reportResults();
    }

    public static void main(String[] args) {
        TestHTMLMenuEditor test = new TestHTMLMenuEditor();
        test.test();
    }
}