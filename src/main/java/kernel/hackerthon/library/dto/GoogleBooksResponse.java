package kernel.hackerthon.library.dto;

import java.util.List;

public class GoogleBooksResponse {
    private String kind;
    private int totalItems;
    private List<BookInfo> items;

    public static class BookInfo {
        private VolumeInfo volumeInfo;

        public VolumeInfo getVolumeInfo() {
            return volumeInfo;
        }

        public void setVolumeInfo(VolumeInfo volumeInfo) {
            this.volumeInfo = volumeInfo;
        }
    }

    public static class VolumeInfo {
        private String title;
        private List<String> authors;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getAuthors() {
            return authors;
        }

        public void setAuthors(List<String> authors) {
            this.authors = authors;
        }
    }

    public String getKind() {
        return kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<BookInfo> getItems() {
        return items;
    }

    public void setItems(List<BookInfo> items) {
        this.items =items;
    }
}
