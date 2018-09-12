class MatrixLink {
    private LinkBeans beans;
    MatrixLink row;
    MatrixLink column;

    MatrixLink() {
        this(0, 0);
    }

    MatrixLink(int iData, double dData) {
        beans = new LinkBeans(iData, dData);
        column = null;
        row = null;
    }

    boolean isEmpty() {
        return row == null;
    }

    void display() {
        System.out.print(" (Int - '" + beans.getIData() + "', Double - '" + beans.getDData() + "')");
    }

    void displayInt() {
        System.out.print(" " + beans.getIData() + " ");
    }

    void displayDouble() {
        System.out.print(" " + beans.getDData() + " ");
    }

    void setIData(int iData) {
        beans.setIData(iData);
    }

    void setDData(double dData) {
        beans.setDData(dData);
    }

    int getIData() {
        return beans.getIData();
    }

    double getDData() {
        return beans.getDData();
    }

    boolean checkByInt(int iData) {
        return iData == beans.getIData();
    }

    boolean checkByDouble(double dData) {
        return dData == beans.getDData();
    }
}

class MatrixLinkList {
    private MatrixLink first;
    final static String INT = "int";
    final static String DOUBLE = "double";
    final static String INT_DOUBLE = "intDouble";
    private boolean isInt;
    private int rows;
    private int columns;

    MatrixLinkList(int rows, int columns) {
        this(rows, columns, DOUBLE);
    }

    MatrixLinkList(int rows, int columns, String type) {
        isInt = type.equals(INT);
        this.rows = rows;
        this.columns = columns;
        first = setGrid(rows, columns);
    }

    private static MatrixLink setGrid(int rows, int columns) {
        MatrixLink link;
        MatrixLink temp;
        MatrixLink t;

        link = new MatrixLink();
        t = link;
        for (int i = 1; i <= rows; i++) {
            temp = t;
            for (int j = 1; j < columns; j++) {
                temp.column = new MatrixLink();
                temp = temp.column;
            }
            if (i < rows) {
                t.row = new MatrixLink();
                t = t.row;
            }
        }
        return link;
    }

    void insert(int iData, double dData, int row, int column) {
        MatrixLink link = first;
        if (row > rows || column > columns) {
            System.out.println("Can't insert at (" + row + ", " + column + ")");
            return;
        }
        for (int i = 1; i < row; i++) {
            link = link.row;
        }

        for (int i = 1; i < column; i++) {
            link = link.column;
        }

        link.setIData(iData);
        link.setDData(dData);
    }

    void insert(int iData, int row, int column) {
        if (isInt)
            insert(iData, 0, row, column);
        else
            insert(0, iData, row, column);
    }

    void insert(double dData, int row, int column) {
        if (isInt)
            insert((int)dData, 0, row, column);
        else
            insert(0, dData, row, column);
    }

    void display() {
        if (isInt)
            displayInts();
        else
            displayDouble();
    }

    void display(String type) {
        switch (type) {
            case INT_DOUBLE:
                MatrixLink link = first;
                MatrixLink temp;

                while (link != null) {
                    temp = link;
                    while (temp != null) {
                        temp.display();
                        temp = temp.column;
                    }
                    System.out.println("");
                    link = link.row;
                }
                break;
            case INT:
                displayInts();
                break;
            case DOUBLE:
                displayDouble();
                break;
            default:
                System.out.println("TYPE Error please choose any one of the Class strings");
                break;
        }
    }

    private void displayInts() {
        MatrixLink link = first;
        MatrixLink temp;

        while (link != null) {
            temp = link;
            while (temp != null) {
                temp.displayInt();
                temp = temp.column;
            }
            System.out.println("");
            link = link.row;
        }
    }

    private void displayDouble() {
        MatrixLink link = first;
        MatrixLink temp;

        while (link != null) {
            temp = link;
            while (temp != null) {
                temp.displayDouble();
                temp = temp.column;
            }
            System.out.println("");
            link = link.row;
        }
    }

}

public class MatrixLinkApp {
    public static void main(String[] args) {
        MatrixLinkList linkList = new MatrixLinkList(3, 4, MatrixLinkList.INT_DOUBLE);
        linkList.insert(1, 1.1, 3, 1);
        linkList.insert(2, 2.2, 3, 2);
        linkList.insert(3, 3.3, 3, 3);
        linkList.insert(4, 4.4, 3, 4);

        linkList.display(MatrixLinkList.INT_DOUBLE);
    }
}
