package ru.itgirl.libraryproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject.dto.AuthorDto;
import ru.itgirl.libraryproject.dto.BookDto;
import ru.itgirl.libraryproject.dto.GenreDto;
import ru.itgirl.libraryproject.model.Genre;
import ru.itgirl.libraryproject.repository.AuthorRepository;
import ru.itgirl.libraryproject.repository.GenreRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    public GenreDto getGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        return convertToDto(genre);
    }
    private GenreDto convertToDto(Genre genre) {
        List<BookDto> bookDtoList = genre.getBooks().stream()
                .map(book -> {
                    Set<AuthorDto> authorDtos = book.getAuthors().stream()
                            .map(author -> AuthorDto.builder()
                                    .id(author.getId())
                                    .name(author.getName())
                                    .surname(author.getSurname())
                                    .build()
                            ).collect(Collectors.toSet());
                    return BookDto.builder()
                            .id(book.getId())
                            .name(book.getName())
                            .authors(authorDtos)
                            .build();
                }).collect(Collectors.toList());

        return GenreDto.builder()
                .id(genre.getId())
                .genre_name(genre.getName())
                .books(bookDtoList)
                .build();
    }
}
