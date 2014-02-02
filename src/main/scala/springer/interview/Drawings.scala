package springer.interview

object Drawings {
  type Canvas = List[List[Char]]

  def rectangleDrawing(xStart: Int, yStart: Int, xEnd: Int, yEnd: Int): Canvas => Canvas = {
    _.zipWithIndex.map {
      case (row, rowIndex) if rowIndex == yStart || rowIndex == yEnd => {
        row.zipWithIndex map {
          case (cell, cellIndex) => if (cellIndex >= xStart && cellIndex <= xEnd) 'x' else cell
        }
      }
      case (row, rowIndex) if rowIndex > yStart && rowIndex < yEnd => {
        row.zipWithIndex map {
          case (cell, cellIndex) => if (cellIndex == xStart || cellIndex == xEnd) 'x' else cell
        }
      }
      case (row, _) => row
    }
  }

  def lineDrawing(xStart: Int, yStart: Int, xEnd: Int, yEnd: Int): Canvas => Canvas = {
    _.zipWithIndex.map {
      case (row, rowIndex) if rowIndex >= yStart && rowIndex <= yEnd => {
        row.zipWithIndex map {
          case (cell, cellIndex) => if (cellIndex >= xStart && cellIndex <= xEnd) 'x' else cell
        }
      }
      case (row, _) => row
    }
  }

  def bucketFill(xAxis: Int, yAxis: Int, color: Char): Canvas => Canvas = {


    def go(canvas: Canvas, xAxis: Int, yAxis: Int, color: Char): Canvas = {
      if (xAxis < 1 || xAxis > canvas(0).size - 2 || yAxis < 1 || yAxis > canvas.size - 2)
        canvas
      else if (canvas(yAxis)(xAxis) == color || canvas(yAxis)(xAxis) == 'x')
        canvas
      else {
        val c1 = canvas.zipWithIndex.map {
          case (row, rowIndex) => {
            row.zipWithIndex.map {
              case (cell, columnIndex) => {
                if (rowIndex == yAxis && columnIndex == xAxis && cell != color && cell != 'x') 'o'
                else cell
              }
            }
          }
        }
        val c2 = go(c1, xAxis + 1, yAxis, color)
        val c3 = go(c2, xAxis, yAxis + 1, color)
        val c4 = go(c3, xAxis - 1, yAxis, color)
        go(c4, xAxis, yAxis - 1, color)
      }
    }

    go(_, xAxis, yAxis, color)
  }

  def canvasDrawing(xAxis: Int, yAxis: Int): Canvas => Canvas = {
    _ => {
      val numberOfRows = yAxis + 2
      val numberOfColumns = xAxis + 2

      (0 until numberOfRows).map {
        case x if x == 0 || x == numberOfRows - 1 => 0.until(numberOfColumns).map(_ => '-').toList
        case _ => 0.until(numberOfColumns).map {
          case x if x == 0 || x == numberOfColumns - 1 => '|'
          case _ => ' '
        }.toList
      }.toList
    }
  }
}

