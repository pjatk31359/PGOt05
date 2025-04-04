import java.util.ArrayList;

class MusicLibrary {
    private String name;
    private String owner;
    private ArrayList<String> tracks;
    private ArrayList<Playlist> playlists;

    public MusicLibrary(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.tracks = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public void addTrack(String track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists in the library.");
        }
    }

    public void removeTrack(String track) {
        tracks.remove(track);
        for (Playlist playlist : playlists) {
            playlist.removeTrack(track);
        }
    }

    public void displayTracks() {
        System.out.println("Music Library: " + name);
        for (String track : tracks) {
            System.out.println(" - " + track);
        }
    }

    public void searchTracks(String phrase) {
        System.out.println("Tracks matching '" + phrase + "':");
        for (String track : tracks) {
            if (track.toLowerCase().contains(phrase.toLowerCase())) {
                System.out.println(" - " + track);
            }
        }
    }

    public void createPlaylist(String playlistName) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equalsIgnoreCase(playlistName)) {
                System.out.println("Playlist already exists.");
                return;
            }
        }
        playlists.add(new Playlist(playlistName));
    }

    private Playlist findPlaylist(String playlistName) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equalsIgnoreCase(playlistName)) {
                return playlist;
            }
        }
        return null;
    }

    public void addTrackToPlaylist(String track, String playlistName) {
        Playlist playlist = findPlaylist(playlistName);
        if (playlist != null) {
            if (tracks.contains(track)) {
                playlist.addTrack(track);
            } else {
                System.out.println("Track not found in library.");
            }
        } else {
            System.out.println("Playlist not found.");
        }
    }

    public void displayAllPlaylists() {
        System.out.println("Playlists:");
        for (Playlist playlist : playlists) {
            playlist.displayPlaylist();
        }
    }
    public void displayPlaylist(String playlistName) {
        Playlist playlist = findPlaylist(playlistName);
        if (playlist != null) {
            playlist.displayPlaylist();
        }
    }
    public int getTrackCount(String track) {
        ArrayList<String> tracks = new ArrayList<>();
        return tracks.size();
    }
    public int getPlaylistCount(String playlistName) {
        ArrayList<String> playlists = new ArrayList<>();
        return playlists.size();
    }

}