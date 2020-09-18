package sqlite.sqlite.payload;

public class RequestDto {
    
    private String row;
    private String col;

    public RequestDto() {
    }

    public RequestDto(String value) {
        this.row = value.substring(4, 5);
        this.col = value.substring(10);
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

}
