package com.mu.util;

import com.mu.entities.Singer;
import com.mu.service.AlbumService;
import com.mu.service.SingerService;
import com.mu.service.SingerTypeService;
import com.mu.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("in")
public class InsertController {
    @Autowired
    private SingerTypeService singerTypeService;

    @Autowired
    private SingerService singerService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private SongService songService;

    /*@RequestMapping("insert")
    public List<Singer> insert() {
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
            if (albums.size() != 0) {
                albumService.insertBatchNoUrl(albums);//插入专辑信息
                for (Album album : albums) {
                    List<Song> songs = album.getSongs();
                    for (Song song : songs) {
                        Album album1 = new Album();
                        album1.setAlbumId(album.getAlbumId());
                        song.setAlbum(album1);
                    }
                    if (songs.size() != 0)
                        songService.insertBatchNoUrl(songs);//插入歌曲信息
                }
            }
        }
        *//**-------------------------------------写操作--------------------------------**//*
        WriteFileContent writeFileContent = new WriteFileContent();
        try {
            writeFileContent.rename1("D:\\static\\music", singers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        *//**-------------------------------------更新--------------------------------**//*
        if (singers.size() != 0) {
            singerService.updateBatch(singers);
            for (Singer singer : singers) {
                if (singer.getAlbums().size() != 0) {
                    albumService.updateBatch(singer.getAlbums());
                    for (Album album : singer.getAlbums()) {
                        if (album.getSongs().size() != 0) {
                            songService.updateBatch(album.getSongs());
                        }
                    }
                }
            }
        }
        return singers;
    }*/

    @RequestMapping("read")
    public List<Singer> read() {
        return singerService.queryAllByLimit(0, 10);
    }
}
