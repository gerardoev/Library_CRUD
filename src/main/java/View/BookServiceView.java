package View;

public class BookServiceView extends BasicAbstractUI{

    /**
     * Creates new form BasicAbstractUI
     *
     * @param prev
     */
    public BookServiceView(Menu prev) {
        super("Book", prev);
        this.jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Get all books", "filter by name", "filter by author", "filter by genre"}));
        this.colNames = new String[4];
        this.colNames[0] = "id";
        this.colNames[1] = "name";
        this.colNames[2] = "author";
        this.colNames[3] = "genre";
    }

    @Override
    void searchAction() {
        switch(this.jComboBox1.getSelectedIndex()){
            case 0:
                this.controller.getBooksAllItems();
                break;
            case 1:
                String name = this.jTextField1.getText();
                this.controller.searchBookByName(name);
                break;
            case 2:
                String author = this.jTextField1.getText();
                this.controller.searchBookByAuthor(author);
                break;
            case 3:
                String genre = this.jTextField1.getText();
                this.controller.searchBookByGenre(genre);
                break;
        }
    }

    @Override
    void createAction() {
        CreateBookView view = new CreateBookView(this,this.controller);
        view.setVisible(true);
        this.setVisible(false);
    }

    @Override
    void updateAction() {
        UpdateBookView view = new UpdateBookView(this, this.controller);
        view.setVisible(true);
        this.setVisible(false);
    }

    @Override
    void deleteAction() {
        DeleteBookView view = new DeleteBookView(this, this.controller);
        view.setVisible(true);
        this.setVisible(false);
    }

    @Override
    void changeCombo() {
        if(this.jComboBox1.getSelectedIndex() == 0){
            this.jLabel2.setVisible(false);
            this.jTextField1.setVisible(false);
        }else {
            this.jTextField1.setSize(100,20);
            this.jLabel2.setVisible(true);
            this.jTextField1.setVisible(true);
        }
    }
}
