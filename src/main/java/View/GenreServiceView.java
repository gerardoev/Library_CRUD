package View;

public class GenreServiceView extends BasicAbstractUI{

    /**
     * Creates new form BasicAbstractUI
     *
     * @param prev
     */
    public GenreServiceView(Menu prev) {
        super("Genre", prev);
        this.jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Get all genres"}));
        this.colNames = new String[2];
        this.colNames[0] = "id";
        this.colNames[1] = "name";
    }

    @Override
    void searchAction() {
        if(this.jComboBox1.getSelectedIndex() == 0){
            this.controller.getGenreAllItems();
        }
    }

    @Override
    void createAction() {
        CreateGendreView view = new CreateGendreView(this,this.controller);
        view.setVisible(true);
        this.setVisible(false);
    }

    @Override
    void updateAction() {
        UpdateGenreView view = new UpdateGenreView(this, this.controller);
        view.setVisible(true);
        this.setVisible(false);
    }

    @Override
    void deleteAction() {
        DeleteGenreView view = new DeleteGenreView(this, this.controller);
        view.setVisible(true);
        this.setVisible(false);
    }

    @Override
    void changeCombo() {

    }
}
