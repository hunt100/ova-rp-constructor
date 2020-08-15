package kz.xaw.ovaanimerp.data.enums;

public enum DocumentTemplateType {
    HTML(".html", "text/html"),
    PDF(".pdf", "application/pdf"),
    TXT(".txt", "text/plain");

    private String extension;
    private String type;

    DocumentTemplateType(String extension, String type) {
        this.extension = extension;
        this.type = type;
    }

    public String getExtension() {
        return extension;
    }

    public String getType() {
        return type;
    }
}
