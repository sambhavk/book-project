package com.karankumar.bookproject.statistics;

import com.karankumar.bookproject.book.model.Book;
import com.karankumar.bookproject.book.model.BookGenre;
import com.karankumar.bookproject.shelf.service.PredefinedShelfService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/stats")
public class StatisticController {

    private final PredefinedShelfService predefinedShelfService;

    public StatisticController(PredefinedShelfService predefinedShelfService) {
        this.predefinedShelfService = predefinedShelfService;
    }

    @GetMapping("/books/most-liked")
    public Optional<Book> getMostLikedBooks(){
        RatingStatistics ratingStatistics = new RatingStatistics(predefinedShelfService);
        return ratingStatistics.findMostLikedBook();
    }

    @GetMapping("/books/least-liked")
    public Optional<Book> getLeastLikedBooks(){
        RatingStatistics ratingStatistics = new RatingStatistics(predefinedShelfService);
        return ratingStatistics.findLeastLikedBook();
    }

    @GetMapping("/books/avg-rating")
    public Optional<Double> getAverageRatingOfReadBooks(){
        RatingStatistics ratingStatistics = new RatingStatistics(predefinedShelfService);
        return ratingStatistics.calculateAverageRatingGiven();
    }

    @GetMapping("/books/longest-read")
    public Optional<Book> getLongestReadBook(){
        PageStatistics pageStatistics = new PageStatistics(predefinedShelfService);
        return pageStatistics.findLongestReadBook();
    }

    @GetMapping("/books/avg-length")
    public Optional<Double> getAverageLengthOfReadBooks(){
        PageStatistics pageStatistics = new PageStatistics(predefinedShelfService);
        return pageStatistics.calculateAveragePageLength();
    }

    @GetMapping("/genre/most-read")
    public Optional<BookGenre> getMostReadGenre(){
        GenreStatistics genreStatistics = new GenreStatistics(predefinedShelfService);
        return genreStatistics.findMostReadGenre();
    }

    @GetMapping("/genre/most-liked")
    public Optional<BookGenre> getMostLikedGenre(){
        GenreStatistics genreStatistics = new GenreStatistics(predefinedShelfService);
        return genreStatistics.findMostLikedGenre();
    }

}
