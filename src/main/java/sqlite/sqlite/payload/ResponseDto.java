package sqlite.sqlite.payload;

public class ResponseDto {
    
    private String row;
    private String col;
    private String val;

    public ResponseDto() {
    }

    public ResponseDto(String row, String col, String val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

    public String getRow() {
        return this.row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getCol() {
        return this.col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getVal() {
        return this.val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "{" +
            " row='" + getRow() + "'" +
            ", col='" + getCol() + "'" +
            ", val='" + getVal() + "'" +
            "}";
    }

}
