package com.JavaBootcamp03.mobilestore.controller;

import com.JavaBootcamp03.mobilestore.dto.ProductDTO;
import com.JavaBootcamp03.mobilestore.entity.ProductEntity;
import com.JavaBootcamp03.mobilestore.payload.response.ApiResponse;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.ProductServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/related")
public class RelatedProductController {

    @Autowired
    private ProductServiceImp productServiceImp;

    @Autowired
    private ModelMapper modelMapper;

    public RelatedProductController(ProductServiceImp productServiceImp, ModelMapper modelMapper){
        this.productServiceImp = productServiceImp;
        this.modelMapper = modelMapper;
    };

    @GetMapping("/list")
    public List<ProductDTO> getAllProduct() {
        return productServiceImp.getAllProduct().stream().map(list -> modelMapper.map(list,ProductDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<ProductDTO> listAllRelatedProduct(@PathVariable("id") int id) {
        ProductEntity productEntity = productServiceImp.getProductById(id);

        ProductDTO productDTO = modelMapper.map(productEntity, ProductDTO.class);

        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }

    @GetMapping("/subCat/{id}")
    public ResponseEntity<List<ProductDTO>> listAllRelatedProductBySubCat(@PathVariable("id") int id) {
        List<ProductEntity> productEntity = productServiceImp.getAllRelatedProduct(id);

        List<ProductDTO> productDTO = productEntity.stream().map(list -> modelMapper.map(list, ProductDTO.class))
                .collect(Collectors.toList());

        return new ResponseEntity<List<ProductDTO>>(productDTO, HttpStatus.OK);
    }

    @PostMapping("subCat")
    public ResponseEntity<?> getAllRelatedProduct (@RequestParam int id_subCat) {
        List<ProductEntity> productEntity = productServiceImp.getAllRelatedProduct(id_subCat);

        ApiResponse baseResponse = new ApiResponse();
        baseResponse.setData(productEntity.stream().map(list -> modelMapper.map(list, ProductDTO.class))
                .collect(Collectors.toList()));

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
