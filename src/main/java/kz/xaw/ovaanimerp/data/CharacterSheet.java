package kz.xaw.ovaanimerp.data;

import kz.xaw.ovaanimerp.data.enums.CharacterType;
import kz.xaw.ovaanimerp.security.AppUser;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "character_sheets")
public class CharacterSheet extends BaseEntity {

    @Column
    private String characterName;

    @Column(name = "bio", columnDefinition="TEXT")
    private String bio;

    @Column(name = "appearance", columnDefinition = "TEXT")
    private String appearance;

    @Column(name = "personality", columnDefinition = "TEXT")
    private String personality;

    @Column
    private String otherNotes;

    @Column
    @Enumerated(EnumType.STRING)
    private CharacterType characterType;

    @Column
    private Integer baseDefense = 2;

    @Column
    private Integer baseHealth = 40;

    @Column
    private Integer baseEndurance = 40;

    @Column
    private Integer baseTv = 0;

    @Column
    private Integer baseDice = 2;

    @OneToMany
    private List<Ability> abilities;

    @OneToMany
    private List<Weakness> weaknesses;

    @OneToMany
    private List<Attack> attacks;

    @ManyToOne
    private AppUser appUser;

    @OneToOne
    private Image image;

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getOtherNotes() {
        return otherNotes;
    }

    public void setOtherNotes(String otherNotes) {
        this.otherNotes = otherNotes;
    }

    public Integer getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(Integer baseDefense) {
        this.baseDefense = baseDefense;
    }

    public Integer getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(Integer baseHealth) {
        this.baseHealth = baseHealth;
    }

    public Integer getBaseEndurance() {
        return baseEndurance;
    }

    public void setBaseEndurance(Integer baseEndurance) {
        this.baseEndurance = baseEndurance;
    }

    public Integer getBaseTv() {
        return baseTv;
    }

    public void setBaseTv(Integer baseTv) {
        this.baseTv = baseTv;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Weakness> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<Weakness> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    public void setCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public Integer getBaseDice() {
        return baseDice;
    }

    public void setBaseDice(Integer baseDice) {
        this.baseDice = baseDice;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
