import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Song
{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
class PlayList
{
	private Song current;
	private Queue<Song> queue;
	public PlayList(Song s, Queue<Song> q)
	{
		setCurrent(s);
		queue = q;
	}
	public Song getNextSong()
	{
		if(!queue.isEmpty())
			return queue.poll();
		return null;
	}
	public boolean addSong(Song s)
	{
		return queue.add(s);
	}
	public Song getCurrent() {
		return current;
	}
	public void setCurrent(Song current) {
		this.current = current;
	}
}
class CD
{
	private String name;
	private Set<Song> songs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Song> getSongs() {
		return songs;
	}

	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}
}
class CDPlayer
{
	private CD cd;
	private PlayList pl;
	public CDPlayer(CD c, PlayList p)
	{
		setCd(c);
		setPl(p);
	}
	public CD getCd() {
		return cd;
	}
	public void setCd(CD cd) {
		this.cd = cd;
	}
	public PlayList getPl() {
		return pl;
	}
	public void setPl(PlayList pl) {
		this.pl = pl;
	}
	public void playSongs()
	{
		Song s;
		while((s = pl.getNextSong()) != null)
		{
			playSong(s);
		}
	}
	private void playSong(Song s) {
		//play song s
	}
}
class JukeBox
{
	private CDPlayer cdPlayer;
	private Set<CD> cds;
	public JukeBox(CDPlayer c, Set<CD> s)
	{
		cdPlayer = c;
		cds = s;
	}
	public void playMusic()
	{
		for(CD c : cds)
		{
			PriorityQueue<Song> q = new PriorityQueue<Song>();
			for(Song s : c.getSongs())
				q.add(s);
			PlayList p = new PlayList(null, q);
			cdPlayer = new CDPlayer(c, p);
			cdPlayer.playSongs();
		}
	}
}
public class C7_3 {

}
