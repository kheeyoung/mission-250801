package com.ll;

public class WiseDTO {
    int _id;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_content() {
        return _content;
    }

    public void set_content(String _content) {
        this._content = _content;
    }

    public String get_author() {
        return _author;
    }

    public void set_author(String _author) {
        this._author = _author;
    }

    String _content;

    public WiseDTO(int _id, String _content, String _author) {
        this._id = _id;
        this._content = _content;
        this._author = _author;
    }

    String _author;
}
