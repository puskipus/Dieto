package com.example.dieto

import com.google.gson.annotations.SerializedName

data class RecipeResponse(

	@field:SerializedName("hits")
	val hits: List<HitsItem?>? = null,

	@field:SerializedName("q")
	val q: String? = null,

	@field:SerializedName("more")
	val more: Boolean? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("from")
	val from: Int? = null,

	@field:SerializedName("to")
	val to: Int? = null
)

data class FAMS(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class VITD(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class Recipe(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("shareAs")
	val shareAs: String? = null,

	@field:SerializedName("cautions")
	val cautions: List<Any?>? = null,

	@field:SerializedName("healthLabels")
	val healthLabels: List<String?>? = null,

	@field:SerializedName("totalTime")
	val totalTime: Any? = null,

	@field:SerializedName("mealType")
	val mealType: List<String?>? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("calories")
	val calories: Any? = null,

	@field:SerializedName("cuisineType")
	val cuisineType: List<String?>? = null,

	@field:SerializedName("uri")
	val uri: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("totalNutrients")
	val totalNutrients: TotalNutrients? = null,

	@field:SerializedName("dietLabels")
	val dietLabels: List<String?>? = null,

	@field:SerializedName("dishType")
	val dishType: List<String?>? = null,

	@field:SerializedName("yield")
	val yield: Any? = null,

	@field:SerializedName("totalWeight")
	val totalWeight: Any? = null,

	@field:SerializedName("digest")
	val digest: List<DigestItem?>? = null,

	@field:SerializedName("ingredients")
	val ingredients: List<IngredientsItem?>? = null,

	@field:SerializedName("totalDaily")
	val totalDaily: TotalDaily? = null,

	@field:SerializedName("ingredientLines")
	val ingredientLines: List<String?>? = null
)

data class HitsItem(

	@field:SerializedName("recipe")
	val recipe: Recipe? = null
)

data class CHOCDFNet(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class VITB12(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class FOLFD(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class CA(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class K(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class FOLDFE(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class RIBF(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class ZN(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class MG(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class WATER(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class CHOLE(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class NIA(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class TOCPHA(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class P(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class FASAT(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class TotalNutrients(

	@field:SerializedName("VITB6A")
	val vITB6A: VITB6A? = null,

	@field:SerializedName("FAMS")
	val fAMS: FAMS? = null,

	@field:SerializedName("VITC")
	val vITC: VITC? = null,

	@field:SerializedName("CHOCDF")
	val cHOCDF: CHOCDF? = null,

	@field:SerializedName("K")
	val k: K? = null,

	@field:SerializedName("VITD")
	val vITD: VITD? = null,

	@field:SerializedName("FATRN")
	val fATRN: FATRN? = null,

	@field:SerializedName("P")
	val p: P? = null,

	@field:SerializedName("CHOLE")
	val cHOLE: CHOLE? = null,

	@field:SerializedName("ENERC_KCAL")
	val eNERCKCAL: ENERCKCAL? = null,

	@field:SerializedName("FASAT")
	val fASAT: FASAT? = null,

	@field:SerializedName("Sugar.alcohol")
	val sugarAlcohol: SugarAlcohol? = null,

	@field:SerializedName("VITK1")
	val vITK1: VITK1? = null,

	@field:SerializedName("CHOCDF.net")
	val cHOCDFNet: CHOCDFNet? = null,

	@field:SerializedName("MG")
	val mG: MG? = null,

	@field:SerializedName("SUGAR.added")
	val sUGARAdded: SUGARAdded? = null,

	@field:SerializedName("RIBF")
	val rIBF: RIBF? = null,

	@field:SerializedName("CA")
	val cA: CA? = null,

	@field:SerializedName("FOLFD")
	val fOLFD: FOLFD? = null,

	@field:SerializedName("WATER")
	val wATER: WATER? = null,

	@field:SerializedName("FAPU")
	val fAPU: FAPU? = null,

	@field:SerializedName("NIA")
	val nIA: NIA? = null,

	@field:SerializedName("THIA")
	val tHIA: THIA? = null,

	@field:SerializedName("FIBTG")
	val fIBTG: FIBTG? = null,

	@field:SerializedName("VITB12")
	val vITB12: VITB12? = null,

	@field:SerializedName("TOCPHA")
	val tOCPHA: TOCPHA? = null,

	@field:SerializedName("SUGAR")
	val sUGAR: SUGAR? = null,

	@field:SerializedName("PROCNT")
	val pROCNT: PROCNT? = null,

	@field:SerializedName("FOLDFE")
	val fOLDFE: FOLDFE? = null,

	@field:SerializedName("NA")
	val nA: NA? = null,

	@field:SerializedName("ZN")
	val zN: ZN? = null,

	@field:SerializedName("VITA_RAE")
	val vITARAE: VITARAE? = null,

	@field:SerializedName("FAT")
	val fAT: FAT? = null,

	@field:SerializedName("FOLAC")
	val fOLAC: FOLAC? = null,

	@field:SerializedName("FE")
	val fE: FE? = null
)

data class DigestItem(

	@field:SerializedName("schemaOrgTag")
	val schemaOrgTag: String? = null,

	@field:SerializedName("total")
	val total: Any? = null,

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("daily")
	val daily: Any? = null,

	@field:SerializedName("hasRDI")
	val hasRDI: Boolean? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("tag")
	val tag: String? = null,

	@field:SerializedName("sub")
	val sub: List<SubItem?>? = null
)

data class VITARAE(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class FOLAC(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class SubItem(

	@field:SerializedName("schemaOrgTag")
	val schemaOrgTag: String? = null,

	@field:SerializedName("total")
	val total: Any? = null,

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("daily")
	val daily: Any? = null,

	@field:SerializedName("hasRDI")
	val hasRDI: Boolean? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("tag")
	val tag: String? = null
)

data class CHOCDF(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class FATRN(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class THIA(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class VITK1(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class PROCNT(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class NA(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class FE(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class TotalDaily(

	@field:SerializedName("VITB6A")
	val vITB6A: VITB6A? = null,

	@field:SerializedName("VITC")
	val vITC: VITC? = null,

	@field:SerializedName("CHOCDF")
	val cHOCDF: CHOCDF? = null,

	@field:SerializedName("K")
	val k: K? = null,

	@field:SerializedName("VITD")
	val vITD: VITD? = null,

	@field:SerializedName("P")
	val p: P? = null,

	@field:SerializedName("CHOLE")
	val cHOLE: CHOLE? = null,

	@field:SerializedName("ENERC_KCAL")
	val eNERCKCAL: ENERCKCAL? = null,

	@field:SerializedName("FASAT")
	val fASAT: FASAT? = null,

	@field:SerializedName("VITK1")
	val vITK1: VITK1? = null,

	@field:SerializedName("MG")
	val mG: MG? = null,

	@field:SerializedName("RIBF")
	val rIBF: RIBF? = null,

	@field:SerializedName("CA")
	val cA: CA? = null,

	@field:SerializedName("NIA")
	val nIA: NIA? = null,

	@field:SerializedName("THIA")
	val tHIA: THIA? = null,

	@field:SerializedName("FIBTG")
	val fIBTG: FIBTG? = null,

	@field:SerializedName("VITB12")
	val vITB12: VITB12? = null,

	@field:SerializedName("TOCPHA")
	val tOCPHA: TOCPHA? = null,

	@field:SerializedName("PROCNT")
	val pROCNT: PROCNT? = null,

	@field:SerializedName("FOLDFE")
	val fOLDFE: FOLDFE? = null,

	@field:SerializedName("NA")
	val nA: NA? = null,

	@field:SerializedName("ZN")
	val zN: ZN? = null,

	@field:SerializedName("VITA_RAE")
	val vITARAE: VITARAE? = null,

	@field:SerializedName("FAT")
	val fAT: FAT? = null,

	@field:SerializedName("FE")
	val fE: FE? = null
)

data class VITC(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class FAPU(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class VITB6A(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class SugarAlcohol(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class SUGARAdded(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class FIBTG(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class ENERCKCAL(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class IngredientsItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("foodId")
	val foodId: String? = null,

	@field:SerializedName("weight")
	val weight: Any? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("foodCategory")
	val foodCategory: String? = null
)

data class FAT(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)

data class SUGAR(

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("quantity")
	val quantity: Any? = null,

	@field:SerializedName("label")
	val label: String? = null
)
