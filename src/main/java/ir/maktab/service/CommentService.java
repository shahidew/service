package ir.maktab.service;

import ir.maktab.dto.CommentDto;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.ExpertDto;
import ir.maktab.service.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    void create(CommentDto commentDto, ExpertDto expertDto, CustomerDto dto);

    void update(CommentDto dto) throws NotFoundException;

    void remove(CommentDto dto) throws NotFoundException;

    List<CommentDto> getAllComments() throws NotFoundException;

    Optional<CommentDto> getCommentByCustomer(CustomerDto customerDto) throws NotFoundException;

    Optional<CommentDto> getCommentByExpert(ExpertDto expertDto) throws NotFoundException;
}
