package ir.maktab.dto.mapper;

import ir.maktab.data.entity.Comment;
import ir.maktab.dto.CommentDto;
import ir.maktab.dto.mapper.user.CustomerMapper;
import ir.maktab.dto.mapper.user.ExpertMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentMapperImpl implements CommentMapper {
    private final CustomerMapper customerMapper;
    private final ExpertMapper expertMapper;

    public CommentMapperImpl(CustomerMapper customerMapper, ExpertMapper expertMapper) {
        this.customerMapper = customerMapper;
        this.expertMapper = expertMapper;
    }

    @Override
    public Comment toComment(CommentDto commentDto) {
        return new Comment()
                .setText(commentDto.getText())
                .setScore(commentDto.getScore())
                .setId(commentDto.getId());
    }

    @Override
    public CommentDto toCommentDto(Comment comment) {
        return new CommentDto()
                .setText(comment.getText())
                .setId(comment.getId())
                .setScore(comment.getScore())
                .setCustomerDto(customerMapper.toCustomerDto(comment.getCustomer()))
                .setExpertDto(expertMapper.toExpertDto(comment.getExpert()));
    }

    @Override
    public List<CommentDto> toCommentDtos(List<Comment> comments) {
        List<CommentDto> commentDtos = new ArrayList<>();
        if (comments.isEmpty()) {
            return commentDtos;
        }
        commentDtos = comments.stream().map(this::toCommentDto).collect(Collectors.toList());
        return commentDtos;
    }

    @Override
    public List<Comment> toComments(List<CommentDto> dtos) {
        List<Comment> comments = new ArrayList<>();
        if (dtos.isEmpty()) {
            return comments;
        }
        comments = dtos.stream().map(this::toComment).collect(Collectors.toList());
        return comments;
    }
}
