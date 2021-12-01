package ir.maktab.dto.mapper;

import ir.maktab.data.entity.Comment;
import ir.maktab.dto.CommentDto;

import java.util.List;

public interface CommentMapper {

    Comment toComment(CommentDto commentDto);

    CommentDto toCommentDto(Comment comment);

    List<CommentDto> toCommentDtos(List<Comment> comments);

    List<Comment> toComments(List<CommentDto> dtos);
}
