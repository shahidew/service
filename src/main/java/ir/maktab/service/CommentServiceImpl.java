package ir.maktab.service;

import ir.maktab.data.entity.Comment;
import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.Expert;
import ir.maktab.data.repository.CommentRepository;
import ir.maktab.dto.CommentDto;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.mapper.CommentMapper;
import ir.maktab.dto.mapper.user.CustomerMapper;
import ir.maktab.dto.mapper.user.ExpertMapper;
import ir.maktab.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final CommentMapper mapper;
    private final CustomerMapper customerMapper;
    private final ExpertMapper expertMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository repository, CommentMapper mapper, CustomerMapper customerMapper, ExpertMapper expertMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.customerMapper = customerMapper;
        this.expertMapper = expertMapper;
    }


    @Override
    public void create(CommentDto commentDto, ExpertDto expertDto, CustomerDto dto) {
        Comment comment = mapper.toComment(commentDto);
        repository.save(comment);
        Expert expert = expertMapper.toExpert(expertDto);
        Customer customer = customerMapper.toCustomer(dto);
        comment.setExpert(expert);
        comment.setCustomer(customer);
        expert.getComments().add(comment);
        customer.getComments().add(comment);
        repository.save(comment);

    }

    @Override
    public void update(CommentDto dto) throws NotFoundException {
        Comment o = mapper.toComment(dto);
        if (repository.findById(dto.getId()).isPresent()) {
            repository.save(o);
        } else {
            throw new NotFoundException("The comment not found!");
        }
    }

    @Override
    public void remove(CommentDto dto) throws NotFoundException {
        Comment o = mapper.toComment(dto);
        if (repository.findById(dto.getId()).isPresent()) {
            repository.save(o);
        } else {
            throw new NotFoundException("The comment not found!");
        }
    }

    @Override
    public List<CommentDto> getAllComments() throws NotFoundException {
        List<Comment> comments = repository.findAll();
        if (comments.isEmpty()) {
            throw new NotFoundException("not found any comment...");
        } else {
            return mapper.toCommentDtos(comments);
        }
    }


    @Override
    public Optional<CommentDto> getCommentByCustomer(CustomerDto customerDto) throws NotFoundException {
        Customer customer = customerMapper.toCustomer(customerDto);
        Optional<Comment> comment = repository.findCommentByCustomer(customer);
        if (!comment.isPresent()) {
            throw new NotFoundException("the comment not found by this customer.");
        }
        CommentDto commentDto = mapper.toCommentDto(comment.get());
        return Optional.ofNullable(commentDto);
    }

    @Override
    public Optional<CommentDto> getCommentByExpert(ExpertDto expertDto) throws NotFoundException {
        Expert expert = expertMapper.toExpert(expertDto);
        Optional<Comment> comment = repository.findCommentByExpert(expert);
        if (!comment.isPresent()) {
            throw new NotFoundException("the comment not found by this expert.");
        }
        CommentDto commentDto = mapper.toCommentDto(comment.get());
        return Optional.ofNullable(commentDto);
    }


}
