package example.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private String name;
    private String artist;
    private String type;
    private MultipartFile filepath;

    public SongForm(String name, String artist, String type, MultipartFile filepath) {
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.filepath = filepath;
    }

    public SongForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MultipartFile getFilepath() {
        return filepath;
    }

    public void setFilepath(MultipartFile filepath) {
        this.filepath = filepath;
    }
}
