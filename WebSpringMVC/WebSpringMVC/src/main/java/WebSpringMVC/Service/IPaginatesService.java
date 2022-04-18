package WebSpringMVC.Service;

import org.springframework.stereotype.Service;

import WebSpringMVC.Dto.PaginatesDto;


@Service
public interface IPaginatesService {
	public PaginatesDto GetInfoPaginates(int totalData, int limit, int currentPage);
}
