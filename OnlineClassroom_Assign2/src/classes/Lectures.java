package classes;

import java.util.Date;
public class Lectures {
    interface Lecture {
        void showData();
    }

    public static class Slides implements Lecture {
        private Date date;
        private Human author;
        private String topic;
        private int numSlides;
        private String[] content;

        public Slides(Human author, String topic, int numSlides, String[] content) {

            this.date = new Date();
            this.author = author;
            this.topic = topic;
            this.numSlides = numSlides;
            this.content = content;
        }

        @Override
        public void showData() {

        }
    }

    class Video implements Lecture {

        private Date date;
        private String topic;
        private String filename;
        private Human author;

        Video(String topic, String filename, Human author) {
            this.date = new Date();
            this.topic = topic;
            this.filename = filename;
            this.author = author;
        }

        @Override
        public void showData() {

        }
    }
}
