package cl.goviedo.securitybasic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesRestController {
    
    protected class Notice {
        public String title;
        public String content;

        public Notice(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Notice{" +
                    "title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        
        }   
    }

    @GetMapping("/notices")
    public List<Notice> getNotices() {
        return new ArrayList<>();
    }
}
