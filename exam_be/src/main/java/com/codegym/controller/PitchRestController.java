package com.codegym.controller;

import com.codegym.dto.PitchDto;
import com.codegym.dto.PitchSearchDto;
import com.codegym.entity.Area;
import com.codegym.entity.Pitch;
import com.codegym.entity.PitchType;
import com.codegym.entity.TimeSlot;
import com.codegym.service.IAreaService;
import com.codegym.service.IPitchService;
import com.codegym.service.IPitchTypeService;
import com.codegym.service.ITimeSlotService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PitchRestController {
    @Autowired
    private IPitchService pitchService;
    @Autowired
    private IPitchTypeService pitchTypeService;
    @Autowired
    private IAreaService areaService;
    @Autowired
    private ITimeSlotService timeSlotService;

    @PostMapping("/pitches/search")
    public ResponseEntity<Page<Pitch>> searchByName(@RequestBody() PitchSearchDto pitchSearchDto, @PageableDefault(size = 3) Pageable pageable) {
        Page<Pitch> pitchPage = null;
        if(pitchSearchDto.getAreaId() == 0 && pitchSearchDto.getPitchTypeId() == 0){
            pitchPage = pitchService.searchByName(pitchSearchDto.getName(), pageable);
        }else if(pitchSearchDto.getAreaId() == 0) {
            pitchPage = pitchService.searchByNameAndPitchType(pitchSearchDto.getName(),pitchSearchDto.getPitchTypeId(),pageable);
        }else if(pitchSearchDto.getPitchTypeId() == 0) {
            pitchPage = pitchService.searchByNameAndArea(pitchSearchDto.getName(),pitchSearchDto.getAreaId(),pageable);
        }else {
            pitchPage = pitchService.searchByThreeField(pitchSearchDto.getName(),
                    pitchSearchDto.getAreaId(),pitchSearchDto.getPitchTypeId(), pageable);
        }
        if(pitchPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pitchPage, HttpStatus.OK);
    }

    @GetMapping("/pitchTypes")
    public ResponseEntity<List<PitchType>> findAllPitchType() {
        List<PitchType> pitchTypeList = pitchTypeService.findAll();
        if(pitchTypeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pitchTypeList, HttpStatus.OK);
    }

    @GetMapping("/timeSlots")
    public ResponseEntity<List<TimeSlot>> findAllTimeSlot() {
        List<TimeSlot> timeSlotList = timeSlotService.findAll();
        if(timeSlotList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(timeSlotList, HttpStatus.OK);
    }

    @GetMapping("/areas")
    public ResponseEntity<List<Area>> findAllArea() {
        List<Area> areaList = areaService.findAll();
        if(areaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(areaList, HttpStatus.OK);
    }

    @DeleteMapping("/pitches/delete/{id}")
    public ResponseEntity<?> deletePitchById(@PathVariable Long id){
        pitchService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/pitches/create")
    public ResponseEntity<?> addPitch(@Validated @RequestBody PitchDto pitchDto, BindingResult bindingResult){
        pitchDto.validate(pitchDto,bindingResult);
        if(pitchService.exitByName(pitchDto.getName())){
            bindingResult.rejectValue("name", "name","Tên sân bóng đã tồn tại");
        }
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.BAD_REQUEST);
        }
        Pitch pitch = new Pitch();
        BeanUtils.copyProperties(pitchDto, pitch);
        pitchService.addPitch(pitch);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
