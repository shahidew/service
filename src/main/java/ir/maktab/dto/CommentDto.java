package ir.maktab.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CommentDto {

    private Long id;

    private String text;

    @NotBlank(message = "score should not be empty")
    private Double score;

    private ExpertDto expertDto;

    private CustomerDto customerDto;

    public CommentDto() {
    }

    public String getText() {
        return text;
    }

    public CommentDto setText(String text) {
        this.text = text;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public CommentDto setScore(Double score) {
        this.score = score;
        return this;
    }

    public ExpertDto getExpertDto() {
        return expertDto;
    }

    public CommentDto setExpertDto(ExpertDto expertDto) {
        this.expertDto = expertDto;
        return this;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public CommentDto setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
        return this;
    }

    public Long getId() {
        return id;
    }

    public CommentDto setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                ", text='" + text + '\'' +
                ", score=" + score +
                ", expertDto=" + expertDto +
                ", customerDto=" + customerDto +
                '}';
    }
}
