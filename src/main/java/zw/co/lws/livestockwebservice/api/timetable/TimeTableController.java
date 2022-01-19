package zw.co.lws.livestockwebservice.api.timetable;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import zw.co.lws.livestockwebservice.service.timetable.find.FindTimeTableService;

@RestController
@RequestMapping("/time-table")
@Tag(name = "Time-Table Controller", description = "Time-Table endpoints")
public class TimeTableController {
    private final FindTimeTableService findTimeTableService;

    public TimeTableController(FindTimeTableService findTimeTableService) {
        this.findTimeTableService = findTimeTableService;
    }

    /*
    @PostMapping(value = "/create")
    public ResponseEntity<TimeTableDto> create(@RequestBody TimeTableCreateRequest timeTableCreateRequest){
        TimeTableResponse timeTableResponse = timeTableService.create(timeTableCreateRequest);
        TimeTableDto timeTableDto = TimeTableDto.of(timeTableResponse.getTimeTable());
        return ResponseEntity.ok(timeTableDto);
    }

    @GetMapping("/get-by/{taskStatus}")
    public ResponseEntity<List<TimeTableDto>> findAllByStatus(@PathVariable TaskStatus taskStatus){
        List<TimeTableResponse> timeTableResponseList = timeTableService.findAllByTaskStatus(taskStatus);
        List<TimeTableDto> timeTableDtoList = new ArrayList<>();
        timeTableResponseList.stream().forEach(timeTableResponse -> timeTableDtoList.add(new TimeTableDto(timeTableResponse.getTimeTable())));
        return ResponseEntity.ok(timeTableDtoList);
    }

    @GetMapping("/get-by-date")
    public ResponseEntity<List<TimeTableDto>> findAllByDate(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("date") LocalDate date){
        List<TimeTableResponse> timeTableResponseList = timeTableService.findByDate(date);
        List<TimeTableDto> timeTableDtoList = new ArrayList<>();
        timeTableResponseList.stream().forEach(timeTableResponse -> timeTableDtoList.add(new TimeTableDto(timeTableResponse.getTimeTable())));
        return ResponseEntity.ok(timeTableDtoList);
    }
    @PutMapping("/update")
    public ResponseEntity<TimeTableDto> update(@RequestBody TimeTableUpdateRequest timeTableUpdateRequest){
        TimeTableResponse timeTableResponse = timeTableService.update(timeTableUpdateRequest);
        TimeTableDto timeTableDto = TimeTableDto.of(timeTableResponse.getTimeTable());
        return ResponseEntity.ok(timeTableDto);
    }

     */

}
