package zw.co.lws.livestockwebservice.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.lws.livestockwebservice.domain.enums.TaskStatus;
import zw.co.lws.livestockwebservice.service.TimeTableResponse;
import zw.co.lws.livestockwebservice.service.TimeTableCreateRequest;
import zw.co.lws.livestockwebservice.service.TimeTableCreateService;
import zw.co.lws.livestockwebservice.service.FindTimeTableService;
import zw.co.lws.livestockwebservice.service.TimeTableUpdateRequest;
import zw.co.lws.livestockwebservice.service.TimeTableUpdateService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/time-table")
@Tag(name = "Time-Table Controller", description = "Time-Table endpoints")
public class TimeTableController {
    private final FindTimeTableService findTimeTableService;
    private final TimeTableCreateService timeTableCreateService;
    private final TimeTableUpdateService timeTableUpdateService;

    public TimeTableController(FindTimeTableService findTimeTableService, TimeTableCreateService timeTableCreateService, TimeTableUpdateService timeTableUpdateService) {
        this.findTimeTableService = findTimeTableService;
        this.timeTableCreateService = timeTableCreateService;
        this.timeTableUpdateService = timeTableUpdateService;
    }


    @PostMapping(value = "/create")
    public ResponseEntity<TimeTableDto> create(@RequestBody TimeTableCreateRequest timeTableCreateRequest){
        TimeTableResponse timeTableResponse = timeTableCreateService.create(timeTableCreateRequest);
        TimeTableDto timeTableDto = TimeTableDto.of(timeTableResponse.getTimeTable());
        return ResponseEntity.ok(timeTableDto);
    }

    @GetMapping("/find-by/{taskStatus}")
    public ResponseEntity<List<TimeTableDto>> findAllByStatus(@PathVariable TaskStatus taskStatus){
        List<TimeTableResponse> timeTableResponseList = findTimeTableService.findAllByTaskStatus(taskStatus);
        List<TimeTableDto> timeTableDtoList = new ArrayList<>();
        timeTableResponseList.forEach(timeTableResponse -> timeTableDtoList.add(new TimeTableDto(timeTableResponse.getTimeTable())));
        return ResponseEntity.ok(timeTableDtoList);
    }

    @GetMapping("/find-by-date")
    public ResponseEntity<List<TimeTableDto>> findAllByDate(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("date") LocalDate date){
        List<TimeTableResponse> timeTableResponseList = findTimeTableService.findByDate(date);
        List<TimeTableDto> timeTableDtoList = new ArrayList<>();
        timeTableResponseList.forEach(timeTableResponse -> timeTableDtoList.add(new TimeTableDto(timeTableResponse.getTimeTable())));
        return ResponseEntity.ok(timeTableDtoList);
    }
    @PutMapping("/update")
    public ResponseEntity<TimeTableDto> update(@RequestBody TimeTableUpdateRequest timeTableUpdateRequest){
        TimeTableResponse timeTableResponse = timeTableUpdateService.update(timeTableUpdateRequest);
        TimeTableDto timeTableDto = TimeTableDto.of(timeTableResponse.getTimeTable());
        return ResponseEntity.ok(timeTableDto);
    }


}
