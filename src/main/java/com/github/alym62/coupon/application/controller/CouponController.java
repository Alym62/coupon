package com.github.alym62.coupon.application.controller;

import com.github.alym62.coupon.application.dto.requests.CreateCouponRequestDto;
import com.github.alym62.coupon.application.dto.responses.CouponResponseDto;
import com.github.alym62.coupon.infra.services.CouponService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/coupon")
@Tag(name = "Coupon", description = "Gerenciamento de cupons de desconto")
public class CouponController {
    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @Operation(summary = "Criar novo cupom")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cupom criado com sucesso",
                    headers = @Header(name = "Location", description = "URI do cupom criado",
                            schema = @Schema(type = "string")),
                    content = @Content(schema = @Schema(implementation = CouponResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<CouponResponseDto> createCoupon(@RequestBody CreateCouponRequestDto createCouponRequestDto) {
        var couponSaved = couponService.createCoupon(createCouponRequestDto);
        return ResponseEntity.created(URI.create("/" + couponSaved.id())).body(couponSaved);
    }

    @Operation(summary = "Deletar cupom por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Cupom deletado com sucesso",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Cupom não encontrado",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable UUID id) {
        couponService.deleteCoupon(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar cupom por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cupom encontrado",
                    content = @Content(schema = @Schema(implementation = CouponResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Cupom não encontrado",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<CouponResponseDto> getCoupon(@PathVariable UUID id) {
        var coupon = couponService.getCouponById(id);
        return ResponseEntity.ok(coupon);
    }
}
