package kz.xaw.ovaanimerp.data;

import kz.xaw.ovaanimerp.data.enums.DocumentTemplateType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "document_template", uniqueConstraints = @UniqueConstraint(columnNames = {"docKey"}))
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DocumentTemplate extends BaseEntity {

    @Column
    private String title;

    @Column
    private String docKey;

    @Column
    private String filename;

    @Column(columnDefinition = "TEXT")
    private String originalText;

    @Column(columnDefinition = "TEXT")
    private String textRus;

    @Column(columnDefinition = "TEXT")
    private String textKz;

    @Column
    @Enumerated(EnumType.STRING)
    private DocumentTemplateType type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocKey() {
        return docKey;
    }

    public void setDocKey(String docKey) {
        this.docKey = docKey;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getTextRus() {
        return textRus;
    }

    public void setTextRus(String textRus) {
        this.textRus = textRus;
    }

    public String getTextKz() {
        return textKz;
    }

    public void setTextKz(String textKz) {
        this.textKz = textKz;
    }

    public DocumentTemplateType getType() {
        return type;
    }

    public void setType(DocumentTemplateType type) {
        this.type = type;
    }
}
