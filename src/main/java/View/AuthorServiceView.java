package View;

import Controller.Controller;

public class AuthorServiceView extends BasicAbstractUI{

    /**
     * Creates new form BasicAbstractUI
     *
     * @param prev
     */
    public AuthorServiceView(Menu prev) {
        super("Author", prev);
        this.jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Get all authors"}));
        this.colNames = new String[2];
        this.colNames[0] = "id";
        this.colNames[1] = "name";
    }

    @Override
    void searchAction() {
        if(this.jComboBox1.getSelectedIndex() == 0){
            this.controller.getAuthorAllItems();
        }
    }

    @Override
    void createAction() {
        CreateAuthorView view = new CreateAuthorView(this,this.controller);
        view.setVisible(true);
        this.setVisible(false);
    }

    @Override
    void updateAction() {
        UpdateAuthor view = new UpdateAuthor(this, this.controller);
        view.setVisible(true);
        this.setVisible(false);
    }

    @Override
    void deleteAction() {
        DeleteAuthorView view = new DeleteAuthorView(this, this.controller);
        view.setVisible(true);
        this.setVisible(false);
    }

    @Override
    void changeCombo() {

    }
}
