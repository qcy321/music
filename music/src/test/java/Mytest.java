import com.mu.Application;
import com.mu.entities.Mv;
import com.mu.entities.MvComment;
import com.mu.entities.Singer;
import com.mu.entities.User;
import com.mu.service.*;
import com.mu.util.WriteFileContent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Mytest {

    @Autowired
    private UserService userService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private SingerService singerService;

    @Autowired
    private SongService songService;

    @Autowired
    private SingerTypeService singerTypeService;

    @Autowired
    private MvService mvService;

    @Autowired
    private MvReplyService mvReplyService;

    @Autowired
    private MvCommentService mvCommentService;

    @Autowired
    private AttentionSingerService attentionSinger;


    @Test
    public void test5(){
       // System.out.println(singerService.queryByFkLimit(1, 0, 15));
        //System.out.println(singerService.queryByFkLimit(1, 0,15));

        System.out.println("1111");
    }

    @Test
    public void test6(){
        System.out.println(albumService.queryByFkSinger(2,0,3));
    }

    /**
     * 批量插入测试
     */
    @Test
    public void test(){
    }

    /*@Test
    public void test1(){
        String path1 = "D:\\static\\music1";
        ReadFileContent readFileContent = new ReadFileContent();
        readFileContent.read1(path1);
        List<Singer> singers = readFileContent.getSingers();//获取所有信息
        singerService.insertBatchNoUrl(singers);//插入歌手信息
        for (Singer singer : singers) {
            List<Album> albums = singer.getAlbums();
            for (Album album : albums) {
                Singer singer1 = new Singer();
                singer1.setSingerId(singer.getSingerId());
                album.setSinger(singer1);
            }
            if (albums.size()!=0) {
                albumService.insertBatchNoUrl(albums);//插入专辑信息
                for (Album album : albums) {
                    List<Song> songs = album.getSongs();
                    for (Song song : songs) {
                        Album album1 = new Album();
                        album1.setAlbumId(album.getAlbumId());
                        song.setAlbum(album1);
                    }
                    if (songs.size()!=0)
                        songService.insertBatchNoUrl(songs);//插入歌曲信息
                }
            }
        }
        *//**-------------------------------------写操作--------------------------------**//*
        WriteFileContent writeFileContent = new WriteFileContent();
        try {
            writeFileContent.rename1("D:\\static\\music",singers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        *//**-------------------------------------更新--------------------------------**//*
        System.out.println(singerService.updateBatch(singers));
        for (Singer singer : singers) {
            albumService.updateBatch(singer.getAlbums());
            for (Album album : singer.getAlbums()) {
                songService.updateBatch(album.getSongs());
            }
        }
    }*/

    @Test
    public void test2(){
        MvComment mvComment = new MvComment();
        mvComment.setContent("偶爱是能够i是");
        Mv mv = new Mv();
        mv.setMvId(1);
        mvComment.setMv(mv);
        mvComment.setContentTime(new Date());
        User user = new User();
        user.setId(1003);
        mvComment.setUser(user);
        System.out.println(mvCommentService.insert(mvComment));
    }

    @Test
    public void test3() throws IOException {
        String path =  "D:/static/mus";
        WriteFileContent writeFileContent = new WriteFileContent();
        List<Singer> singers = singerService.queryAllByLimit(0, 2);
        writeFileContent.rename1(path,singers);
        //writeFileContent.rename1(path,singers);
    }

}
