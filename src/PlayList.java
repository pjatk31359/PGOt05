import java.util.ArrayList;

class Playlist {
    private String name;
    private ArrayList<String> tracks;

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTrack(String track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already in the playlist.");
        }
    }

    public void displayPlaylist() {
        System.out.println("Playlist: " + name);
        for (String track : tracks) {
            System.out.println(" - " + track);
        }
    }

    public boolean containsTrack(String track) {
        return tracks.contains(track);
    }

    public void removeTrack(String track) {
        tracks.remove(track);
    }
}